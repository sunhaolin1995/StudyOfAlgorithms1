"""财报手术刀 (Financial Scalpel) Streamlit 应用。

运行方式：
    streamlit run app.py

依赖：
    streamlit yfinance pdfplumber openai plotly pandas
"""

import json
import re
from io import BytesIO
from typing import Any

import pandas as pd
import pdfplumber
import plotly.graph_objects as go
import streamlit as st
import yfinance as yf
from openai import OpenAI


APP_TITLE = "🔪 财报手术刀 - 核心财务指标可视化提取器"
DEEPSEEK_BASE_URL = "https://api.deepseek.com"
DEEPSEEK_MODEL = "deepseek-chat"
MAX_PDF_PAGES = 20


SYSTEM_PROMPT = """
你是一名严谨、保守、精通上市公司财报的财务分析师。
你的任务是从用户提供的 yfinance 利润表文本或财报 PDF 文本中，提取并整理适合绘制桑基图的核心利润表指标。

必须优先提取这些指标：
- 总营收 / Total Revenue
- 主营业务成本 / Cost of Revenue
- 毛利润 / Gross Profit
- 营销费用 / Selling and Marketing Expense / SG&A 中可识别的销售营销部分
- 研发费用 / Research and Development
- 行政费用 / General and Administrative / SG&A 中可识别的行政部分
- 营业利润 / Operating Income
- 净利润 / Net Income

输出要求：
1. 只输出一段纯 JSON 数组，不要输出 Markdown、代码块、解释文字或多余注释。
2. JSON 数组中每个元素必须严格包含 source、target、value 三个字段。
3. value 必须是数字，统一使用原始文本中最合理的同一数量级；如果原始单位是千、百万、十亿，请在同一 JSON 内保持一致。
4. 必须尽最大努力保证数据逻辑配平，例如：总营收 = 主营业务成本 + 毛利润；毛利润 = 各项费用/税费/其他支出 + 净利润，必要时可增加“其他费用/调整项”。
5. 若某些细分费用无法可靠识别，可以合并为“其他费用/调整项”，但不要编造不存在的大额项目。

示例格式：
[
  {"source": "总营收", "target": "主营业务成本", "value": 5000},
  {"source": "总营收", "target": "毛利润", "value": 5000},
  {"source": "毛利润", "target": "营销费用", "value": 1000},
  {"source": "毛利润", "target": "净利润", "value": 4000}
]
""".strip()


# -----------------------------
# 页面与状态初始化
# -----------------------------
def configure_page() -> None:
    """配置 Streamlit 页面基础信息。"""
    st.set_page_config(page_title=APP_TITLE, layout="wide")
    st.title(APP_TITLE)
    st.caption("自动抓取 / 解析财报文本，调用 DeepSeek 清洗指标，并生成专业金融风桑基图。")


def init_session_state() -> None:
    """初始化跨按钮共享的会话状态。"""
    defaults: dict[str, Any] = {
        "raw_financial_text": "",
        "raw_source_label": "",
        "sankey_data": None,
        "llm_raw_response": "",
    }
    for key, value in defaults.items():
        if key not in st.session_state:
            st.session_state[key] = value


def render_sidebar() -> tuple[str, str]:
    """渲染侧边栏配置项，并返回 API Key 与数据源模式。"""
    with st.sidebar:
        st.header("⚙️ 配置")
        api_key = st.text_input("DeepSeek API Key", type="password", help="用于调用 DeepSeek Chat API。")
        data_mode = st.radio(
            "数据源模式",
            options=("输入股票代码 (自动拉取)", "上传财报 PDF (手动解析)"),
            index=0,
        )
        st.divider()
        st.markdown(
            """
            **使用流程**  
            1. 选择数据源并获取文本  
            2. 点击生成桑基图数据  
            3. 查看图表并导出 CSV
            """
        )
    return api_key, data_mode


def dataframe_to_markdown(df: pd.DataFrame) -> str:
    """不依赖 tabulate，将 DataFrame 转换为 Markdown 表格文本。"""
    display_df = df.reset_index().rename(columns={"index": "Metric"})
    headers = [str(column) for column in display_df.columns]
    rows = [[str(value) for value in row] for row in display_df.to_numpy()]

    header_line = "| " + " | ".join(headers) + " |"
    separator_line = "| " + " | ".join(["---"] * len(headers)) + " |"
    row_lines = ["| " + " | ".join(row) + " |" for row in rows]
    return "\n".join([header_line, separator_line, *row_lines])


# -----------------------------
# 数据源 A：yfinance 股票利润表
# -----------------------------
def fetch_income_statement_text(ticker_symbol: str) -> str:
    """使用 yfinance 拉取最近一个年度利润表，并转换为 Markdown 文本。"""
    cleaned_ticker = ticker_symbol.strip().upper()
    if not cleaned_ticker:
        raise ValueError("请输入有效的股票代码，例如 AAPL、MSFT、PDD。")

    ticker = yf.Ticker(cleaned_ticker)
    financials = ticker.financials

    if financials is None or financials.empty:
        raise ValueError(f"未找到 {cleaned_ticker} 的年度利润表数据，请检查股票代码或稍后重试。")

    latest_period = financials.columns[0]
    latest_df = financials[[latest_period]].copy()
    latest_df.columns = [str(latest_period.date()) if hasattr(latest_period, "date") else str(latest_period)]
    latest_df = latest_df.dropna(how="all")

    if latest_df.empty:
        raise ValueError(f"{cleaned_ticker} 最近年度利润表为空，无法继续分析。")

    markdown_table = dataframe_to_markdown(latest_df)
    return f"Ticker: {cleaned_ticker}\nLatest annual income statement:\n\n{markdown_table}"


def render_ticker_mode() -> None:
    """渲染股票代码直连模式。"""
    st.subheader("模式 A：输入股票代码自动拉取")
    ticker_symbol = st.text_input("Ticker", value="AAPL", placeholder="例如：AAPL, MSFT, PDD")

    if st.button("获取财务数据", type="primary"):
        with st.spinner("正在通过 yfinance 获取最近年度利润表..."):
            try:
                raw_text = fetch_income_statement_text(ticker_symbol)
                st.session_state.raw_financial_text = raw_text
                st.session_state.raw_source_label = f"Ticker: {ticker_symbol.strip().upper()}"
                st.session_state.sankey_data = None
                st.success("财务数据获取成功。")
            except Exception as exc:
                st.error(f"获取财务数据失败：{exc}")


# -----------------------------
# 数据源 B：PDF 文档解析
# -----------------------------
def extract_pdf_text(uploaded_file: Any, max_pages: int = MAX_PDF_PAGES) -> str:
    """使用 pdfplumber 提取 PDF 前 max_pages 页文本。"""
    if uploaded_file is None:
        raise ValueError("请先上传 PDF 文件。")

    pdf_bytes = uploaded_file.getvalue()
    pages_text: list[str] = []

    with pdfplumber.open(BytesIO(pdf_bytes)) as pdf:
        total_pages = min(len(pdf.pages), max_pages)
        for index in range(total_pages):
            page_text = pdf.pages[index].extract_text() or ""
            if page_text.strip():
                pages_text.append(f"\n--- Page {index + 1} ---\n{page_text}")

    extracted_text = "\n".join(pages_text).strip()
    if not extracted_text:
        raise ValueError("PDF 前 20 页未提取到可用文本，可能是扫描版 PDF，请先进行 OCR。")

    return extracted_text


def render_pdf_mode() -> None:
    """渲染 PDF 上传解析模式。"""
    st.subheader("模式 B：上传财报 PDF 手动解析")
    uploaded_file = st.file_uploader("上传财报 PDF", type=["pdf"])

    if st.button("提取文字", type="primary"):
        with st.spinner(f"正在提取 PDF 前 {MAX_PDF_PAGES} 页文本..."):
            try:
                raw_text = extract_pdf_text(uploaded_file)
                st.session_state.raw_financial_text = raw_text
                st.session_state.raw_source_label = uploaded_file.name if uploaded_file else "PDF 财报"
                st.session_state.sankey_data = None
                st.success("PDF 文字提取成功。")
            except Exception as exc:
                st.error(f"提取 PDF 文字失败：{exc}")


# -----------------------------
# LLM 调用与 JSON 清洗
# -----------------------------
def call_deepseek_for_sankey_data(api_key: str, source_text: str) -> str:
    """调用 DeepSeek API，将原始财务文本转换为桑基图 JSON。"""
    if not api_key.strip():
        raise ValueError("请先在左侧边栏输入 DeepSeek API Key。")
    if not source_text.strip():
        raise ValueError("请先获取股票财务数据或提取 PDF 文本。")

    client = OpenAI(api_key=api_key.strip(), base_url=DEEPSEEK_BASE_URL)
    response = client.chat.completions.create(
        model=DEEPSEEK_MODEL,
        temperature=0,
        messages=[
            {"role": "system", "content": SYSTEM_PROMPT},
            {"role": "user", "content": source_text[:60000]},
        ],
    )

    content = response.choices[0].message.content if response.choices else ""
    if not content:
        raise ValueError("DeepSeek 返回内容为空。")
    return content.strip()


def parse_json_array(llm_response: str) -> list[dict[str, Any]]:
    """解析 LLM 返回的 JSON 数组，并进行基础字段校验。"""
    cleaned = llm_response.strip()

    # 兼容模型偶尔返回 ```json ... ``` 的情况，但仍要求内部是 JSON 数组。
    fence_match = re.search(r"```(?:json)?\s*(.*?)\s*```", cleaned, flags=re.DOTALL | re.IGNORECASE)
    if fence_match:
        cleaned = fence_match.group(1).strip()

    # 兼容返回前后带少量说明文字的情况，提取第一个 JSON 数组。
    if not cleaned.startswith("["):
        array_match = re.search(r"\[.*\]", cleaned, flags=re.DOTALL)
        if array_match:
            cleaned = array_match.group(0)

    try:
        data = json.loads(cleaned)
    except json.JSONDecodeError as exc:
        raise ValueError(f"LLM 返回内容不是合法 JSON：{exc}") from exc

    if not isinstance(data, list) or not data:
        raise ValueError("LLM 返回的 JSON 必须是非空数组。")

    for index, item in enumerate(data, start=1):
        if not isinstance(item, dict):
            raise ValueError(f"第 {index} 条数据不是对象。")
        missing_keys = {"source", "target", "value"} - set(item)
        if missing_keys:
            raise ValueError(f"第 {index} 条数据缺少字段：{', '.join(sorted(missing_keys))}。")
        if not item["source"] or not item["target"]:
            raise ValueError(f"第 {index} 条数据的 source/target 不能为空。")
        try:
            item["value"] = float(item["value"])
        except (TypeError, ValueError) as exc:
            raise ValueError(f"第 {index} 条数据的 value 必须是数字。") from exc
        if item["value"] < 0:
            raise ValueError(f"第 {index} 条数据的 value 不能为负数。")

    return data


def render_llm_action(api_key: str) -> None:
    """渲染生成桑基图数据按钮与原始文本预览。"""
    if st.session_state.raw_financial_text:
        st.info(f"当前数据源：{st.session_state.raw_source_label or '未命名数据源'}")
        with st.expander("查看待分析原始文本", expanded=False):
            st.text_area("原始文本", st.session_state.raw_financial_text, height=260)

    if st.button("生成桑基图数据", type="primary", use_container_width=True):
        with st.spinner("DeepSeek 正在清洗财务指标并生成桑基图数据..."):
            try:
                llm_response = call_deepseek_for_sankey_data(api_key, st.session_state.raw_financial_text)
                sankey_data = parse_json_array(llm_response)
                st.session_state.llm_raw_response = llm_response
                st.session_state.sankey_data = sankey_data
                st.success("桑基图数据生成成功。")
            except Exception as exc:
                st.session_state.sankey_data = None
                st.error(f"生成桑基图数据失败：{exc}")
                if st.session_state.llm_raw_response:
                    with st.expander("查看最近一次 LLM 原始返回", expanded=False):
                        st.code(st.session_state.llm_raw_response, language="json")


# -----------------------------
# 可视化与数据导出
# -----------------------------
def draw_sankey(data_list: list[dict[str, Any]]) -> go.Figure:
    """使用 Plotly 绘制高级金融风桑基图。"""
    labels = sorted({item["source"] for item in data_list} | {item["target"] for item in data_list})
    label_to_index = {label: index for index, label in enumerate(labels)}

    sources = [label_to_index[item["source"]] for item in data_list]
    targets = [label_to_index[item["target"]] for item in data_list]
    values = [float(item["value"]) for item in data_list]

    node_colors = ["#1F2937" if index % 2 == 0 else "#2563EB" for index in range(len(labels))]
    link_colors = ["rgba(37, 99, 235, 0.40)" for _ in data_list]

    fig = go.Figure(
        data=[
            go.Sankey(
                arrangement="snap",
                node={
                    "pad": 22,
                    "thickness": 22,
                    "line": {"color": "rgba(148, 163, 184, 0.65)", "width": 0.8},
                    "label": labels,
                    "color": node_colors,
                },
                link={
                    "source": sources,
                    "target": targets,
                    "value": values,
                    "color": link_colors,
                },
            )
        ]
    )
    fig.update_layout(
        title={"text": "核心财务指标流向桑基图", "x": 0.02, "xanchor": "left"},
        font={"size": 14, "color": "#E5E7EB"},
        paper_bgcolor="#0B1120",
        plot_bgcolor="#0B1120",
        height=680,
        margin={"l": 20, "r": 20, "t": 70, "b": 20},
    )
    return fig


def convert_data_to_dataframe(data_list: list[dict[str, Any]]) -> pd.DataFrame:
    """将桑基图 JSON 数据转换为表格。"""
    df = pd.DataFrame(data_list)
    return df[["source", "target", "value"]]


def dataframe_to_csv_bytes(df: pd.DataFrame) -> bytes:
    """将表格转换为 UTF-8-SIG CSV，兼容 Excel 中文显示。"""
    return df.to_csv(index=False).encode("utf-8-sig")


def render_outputs() -> None:
    """渲染桑基图、数据表格和 CSV 下载按钮。"""
    sankey_data = st.session_state.sankey_data
    if not sankey_data:
        return

    st.divider()
    st.subheader("📊 可视化结果")

    try:
        fig = draw_sankey(sankey_data)
        st.plotly_chart(fig, use_container_width=True)
    except Exception as exc:
        st.error(f"绘制桑基图失败：{exc}")
        return

    try:
        df = convert_data_to_dataframe(sankey_data)
        st.subheader("🧾 清洗后的结构化数据")
        st.dataframe(df, use_container_width=True, hide_index=True)

        st.download_button(
            label="下载 CSV 数据",
            data=dataframe_to_csv_bytes(df),
            file_name="financial_scalpel_sankey_data.csv",
            mime="text/csv",
            use_container_width=True,
        )
    except Exception as exc:
        st.error(f"展示或导出数据失败：{exc}")


# -----------------------------
# 应用入口
# -----------------------------
def main() -> None:
    """Streamlit 应用入口函数。"""
    configure_page()
    init_session_state()
    api_key, data_mode = render_sidebar()

    left_col, right_col = st.columns([1, 1], gap="large")
    with left_col:
        if data_mode == "输入股票代码 (自动拉取)":
            render_ticker_mode()
        else:
            render_pdf_mode()

    with right_col:
        st.subheader("LLM 数据清洗")
        render_llm_action(api_key)

    render_outputs()


if __name__ == "__main__":
    main()

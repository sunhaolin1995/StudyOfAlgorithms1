package com.example.hello.Offer;

import java.util.ArrayList;
import java.util.Arrays;

public class No38Permutation {

    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        for (int i = 0; i < abc.size(); i++) {
            System.out.println(abc.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        //转字符数组
        char[] charStr = str.toCharArray();
        //按字典序排序
        Arrays.sort(charStr);
        boolean[] vis = new boolean[str.length()];
        //标记每个位置的字符是否被使用过
        Arrays.fill(vis, false);
        StringBuffer temp = new StringBuffer();
        recursion(res, charStr, temp, vis);
        return res;
    }

    public static void recursion(ArrayList<String> res, char[] str, StringBuffer temp, boolean[] vis) {
        //临时字符串满了加入输出
        if (temp.length() == str.length) {
            res.add(temp.toString());
            return;
        }
        //遍历所有元素选取一个加入
        for (int i = 0; i < str.length; i++) {
            //如果该元素已经被加入了，就不用在加入了
            if (vis[i]) {
                continue;
            }
            if (i > 0 && str[i - 1] == str[i] && vis[i - 1]) {
                //当前元素str[i]与同一层的前一个元素str[i-1]相同且str[i-1]已经用过了
                continue;
            }
            //标记为使用过
            vis[i] =true;
            //加入临时字符串
            temp.append(str[i]);
            recursion(res,str,temp,vis);
            //回溯
            vis[i] =false;
            temp.deleteCharAt(temp.length()-1);
        }

    }

}

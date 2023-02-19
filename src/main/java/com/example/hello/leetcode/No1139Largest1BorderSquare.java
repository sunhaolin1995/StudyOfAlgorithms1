package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2/19/23 16:20
 */
public class No1139Largest1BorderSquare {

    public static void main(String[] args) {
        int[][] grid= {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(largest1BorderedSquare(grid));

    }

    public static int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: (i,j)横向连续1的个数
        //dp[i][j][1]: (i,j)竖向连续1的个数
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果当前位置是0，就跳过
                if (grid[i - 1][j - 1] == 0)
                    continue;
                //如果是1，我们就计算横向和竖向连续1的个数
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int maxSide = 0;//记录正方形的最大长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //沿着当前坐标往上和往左找出最短的距离，暂时看做是正方形的边长(正方形的具体边长
                //还要看上边和左边的长度，所以这里要判断一下)
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                //如果边长小于maxSide，即使找到了也不可能再比maxSide大，所以我们没必要再找，直接跳过，
                if (curSide <= maxSide)
                    continue;
                //curSide可以认为是正方形下边和右边的长度，我们还需要根据正方形上边和左边的长度
                //来确认是否满足正方形的条件
                for (; curSide > maxSide; curSide--) {
                    //判断正方形的左边和上边的长度是否大于curSide，如果不大于，我们就缩小正方形
                    //的长度curSide，然后继续判断
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        //更短的就没必要考虑了，这里直接中断
                        break;
                    }
                }
            }
        }
        //返回正方形的边长
        return maxSide * maxSide;
    }

}

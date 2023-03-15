package com.example.hello.leetcode;

import java.util.Arrays;

public class No1615MaximalNetworkRank {

    public static void main(String[] args) {
        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        System.out.println(maximalNetworkRank(8,roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] convert = new boolean[n][n];

        int[] degree = new int[n];
        for (int[] v : roads) {
            convert[v[0]][v[1]] = true;
            convert[v[1]][v[0]] = true;
            degree[v[0]]++;
            degree[v[1]]++;
        }
        int res = 0;

        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j <n ; j++) {
                int rank = degree[i]+degree[j] -(convert[i][j]?1:0);
                res = Math.max(rank,res);
            }
        }

        return res;
    }


}

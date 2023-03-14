package com.example.hello.leetcode;

public class No1605RestoreMatrix {

    public static void main(String[] args) {
       int[] rowSum = {5,7,10}, colSum = {8,6,8};
        System.out.println(restoreMatrix(rowSum,colSum));
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int m = rowSum.length, n = colSum.length;
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mat[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= mat[i][j];
                colSum[j] -= mat[i][j];
            }
        }
        return mat;
        /*int n = rowSum.length, m = colSum.length;
        int[][] matrix = new int[n][m];
        int i = 0, j = 0;
        while (i < n && j < m) {
            int v = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = v;
            rowSum[i] -= v;
            colSum[j] -= v;
            if (rowSum[i] == 0) {
                ++i;
            }
            if (colSum[j] == 0) {
                ++j;
            }
        }
        return matrix;*/
    }

}

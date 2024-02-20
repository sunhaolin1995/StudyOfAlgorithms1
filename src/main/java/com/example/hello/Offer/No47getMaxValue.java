package com.example.hello.Offer;

public class No47getMaxValue {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        // write code here
        // return maxValue(grid, grid.length - 1, grid[0].length - 1);

        int[][] cvt = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    cvt[i][j] = Math.max(cvt[i][j], cvt[i - 1][j]);
                }
                if (j > 0) {
                    cvt[i][j] = Math.max(cvt[i][j], cvt[i][j - 1]);
                }
                cvt[i][j] = cvt[i][j]+grid[i][j];
            }
        }
        return cvt[rows-1][cols-1];

    }

    public static int maxValue(int[][] grid, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return grid[rows][cols];
        }
        int left = 0, top = 0;
        if (rows >= 1) {
            top = maxValue(grid, rows - 1, cols);
        }
        if (cols >= 1) {
            left = maxValue(grid, rows, cols - 1);
        }
        return Math.max(top, left) + grid[rows][cols];

    }

}

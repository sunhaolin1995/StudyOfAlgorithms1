package com.example.hello.Offer;

public class No13MovingCount {
    public static void main(String[] args) {
        int threshold = 10, rows = 1, cols = 100;
        System.out.println(movingCount(threshold, rows, cols));
    }


    public static int count = 0;


    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] cvt = new boolean[rows][cols];

        dfs(threshold, 0, 0, rows, cols, cvt);

        return count;
    }

    public static void dfs(int threshold, int i, int j, int rows, int cols, boolean[][] cvt) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || cvt[i][j]) {
            return;
        }
        int sum = 0;
        int ti = i, tj = j;
        while (ti > 0) {
            sum += ti % 10;
            ti /= 10;
        }
        while (tj > 0) {
            sum += tj % 10;
            tj /= 10;
        }
        if (sum <= threshold) {
            count++;
        } else {
            return;
        }
        cvt[i][j] = true;
        dfs(threshold, i + 1, j, rows, cols, cvt);
        dfs(threshold, i, j + 1, rows, cols, cvt);
        dfs(threshold, i - 1, j, rows, cols, cvt);
        dfs(threshold, i, j - 1, rows, cols, cvt);
    }

}

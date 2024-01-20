package com.example.hello.Offer;

public class No13MovingCount {

    public static void main(String[] args) {
        int threshold = 1, rows = 2, cols = 3;
        System.out.println(movingCount(threshold, rows, cols));
    }

    public static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(threshold, i, j, rows, cols);
            }
        }
        return count;
    }

    public static void dfs(int threshold, int i, int j, int rows, int cols) {

        if (i < 0 || j < 0 || i > rows || j > cols) {
            return;
        }
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }

        if (sum > threshold) {
            return;
        }else {
            count++;
        }

        dfs(threshold,i+1,j,rows,cols);
        dfs(threshold,i,j+1,rows,cols);
        dfs(threshold,i-1,j,rows,cols);
        dfs(threshold,i,j-1,rows,cols);
    }

}

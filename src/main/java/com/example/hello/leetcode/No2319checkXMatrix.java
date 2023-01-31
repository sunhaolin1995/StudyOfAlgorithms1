package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 1/31/23 09:52
 */
public class No2319checkXMatrix {
    public static void main(String[] args) {
        int[][] grid  =  {{5,7,0},{0,3,1},{0,5,0}};
        System.out.println(checkXMatrix(grid));
    }

    public static boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid.length ; j++) {
                if ((i == j) || (i == grid.length-1 -j)){
                  if (grid[i][j] == 0){
                      return false;
                  }
                } else if ((i != j) && (i != grid.length-1 -j)) {
                    if (grid[i][j] != 0){
                        return false;
                    }

                }
            }
        }
        return true;
    }

}

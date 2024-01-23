package com.example.hello.Offer;

import java.util.ArrayList;

/**
 * @author 孙浩林
 * @date: 1/23/24 16:06
 */
public class No29printMatrixClockWosely {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> integers = printMatrix(matrix);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //先排除特殊情况
        if (matrix.length == 0) {
            return res;
        }
        //左边界
        int left = 0;
        //右边界
        int right = matrix[0].length - 1;
        //上边界
        int up = 0;
        //下边界
        int down = matrix.length - 1;
        //直到边界重合
        while (left <= right && up<= down){
            //上边界的从左到右
            for (int i = left; i <= right ; i++) {
                res.add(matrix[up][i]);
            }
            //上边界向下
            up++;
            if (up > down){
                break;
            }
            //右边界从上到下
            for (int i = up; i <=down ; i++) {
                res.add(matrix[i][right]);
            }
            //右边界向左
            right--;
            if (left > right){
                break;
            }
            //下边界从右到左
            for (int i = right; i >= left ; i--) {
                res.add(matrix[down][i]);
            }
            //下边界向上
            down--;
            if (up > down){
                break;
            }
            //左边界的从下到上
            for (int i = down; i >=up ; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right){
                break;
            }
        }
        return res;
    }

}

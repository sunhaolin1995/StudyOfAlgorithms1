package com.example.hello.leetcode;

import java.util.Arrays;

public class No1637MaxWidthOfVerticalArea {

    public static void main(String[] args) {

        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));

    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] convert = new int[points.length];
        for (int i = 0; i < points.length ; i++) {
            convert[i] = points[i][0];
        }
        Arrays.sort(convert);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < convert.length-1 ; i++) {
            res = Math.max(res,convert[i+1]-convert[i]);
        }
        return res;
    }

}

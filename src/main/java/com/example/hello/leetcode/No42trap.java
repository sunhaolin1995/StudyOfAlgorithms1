package com.example.hello.leetcode;


public class No42trap {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int length = height.length;

        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightNum = new int[length];
        rightNum[length-1] = height[length-1];
        for (int i = length-2; i >=0 ; i--) {
            rightNum[i]  = Math.max(rightNum[i+1],height[i] );
        }

        int res =0;
        for (int i = 0; i <length ; i++) {
            res =res+(Math.min(leftMax[i],rightNum[i])-height[i]);
        }

        return res;

    }
}

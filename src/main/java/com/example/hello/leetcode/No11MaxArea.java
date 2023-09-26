package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/26/23 16:58
 */
public class No11MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left =0,right = height.length-1;
        int res = 0;
        while (left < right){
            res = Math.max(Math.min(height[left],height[right])*)


        }


    }

}

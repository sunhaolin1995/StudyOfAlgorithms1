package com.example.hello.leetcode;

public class No11MaxArea {

    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
         int left =0, right = height.length-1;
         int maxArea = 0;
         while (left < right){
             maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
             if (height[left] < height[right]){
                 left++;
             }else {
                 right--;
             }
         }
        return maxArea;

    }

}

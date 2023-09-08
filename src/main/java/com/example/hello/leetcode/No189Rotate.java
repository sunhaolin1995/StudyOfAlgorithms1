package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/3/30 2:52 下午
 */
public class No189Rotate {
    public static void main(String[] args) {
      int[] nums ={-1};
      int k=2;

      rotate(nums,k);
      for (int i = 0; i < nums.length; i++) {
          System.out.println(nums[i]);
      }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n ; i++) {
            newArr[(i+k)%n] = nums[i];
        }
        for (int i = 0; i <n ; i++) {
            nums[i] = newArr[i];
        }























/*
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);*/
    }


    private static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }




}

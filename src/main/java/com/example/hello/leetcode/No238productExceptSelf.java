package com.example.hello.leetcode;


public class No238productExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int i : ints
        ) {
            System.out.println(i);
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] leftNum = new int[length];
        leftNum[0] = 1;
        for (int i = 1; i < length; i++) {
            leftNum[i] = leftNum[i-1]*nums[i-1];
        }

        int[] rightNum = new int[length];
        rightNum[length-1] = 1;
        for (int i = length-2; i >=0 ; i--) {
            rightNum[i] = rightNum[i+1]*nums[i+1];
        }
        for (int i = 0; i < length; i++) {
            res[i] = leftNum[i]*rightNum[i];
        }
        return res;
    }


}

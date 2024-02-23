package com.example.hello.Offer;

public class No63maxDiff {

    public static void main(String[] args) {
        int[] nums = {9,11,8,5,7,12,16,14};
        System.out.println(maxDiff(nums));
    }

    public static int maxDiff(int[] nums) {
        int min = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            min =Math.min(min,nums[i]);
            res =Math.max(res,nums[i]-min);
        }
        return res;
    }

}

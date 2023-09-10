package com.example.hello.leetcode;

public class No55canJump {

    public static void main(String[] args) {
        int[] nums = {2,0};
        System.out.println(canJump(nums));

    }

    public static boolean canJump(int[] nums) {
        if (nums.length <=1){
            return true;
        }
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= i){
                maxReach =Math.max(maxReach, i+nums[i]);
            }
            if (maxReach >= nums.length-1){
                return true;
            }
        }
        return false;
    }

}

package com.example.hello.leetcode;

public class No169majorityElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int i = nums[0], count = 1;

        for (int j = 1; j < nums.length; j++) {
            if (i == nums[j]) {
                count = count + 1;
            } else {
                count = count - 1;
            }
            if (count == 0) {
                i = nums[j];
                count=1;
             }
        }

        return i;
    }
}

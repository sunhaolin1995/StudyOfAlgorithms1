package com.example.hello.leetcode;

public class No80RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        for (int n:
             nums) {
            System.out.println(n);
        }
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int leftNum = 2; // 初始化为2，因为前两个元素一定保留
        for (int rightNum = 2; rightNum < nums.length; rightNum++) {
            if (nums[leftNum - 2] != nums[rightNum]) {
                nums[leftNum] = nums[rightNum];
                leftNum++;
            }
        }

        return leftNum;
    }

}

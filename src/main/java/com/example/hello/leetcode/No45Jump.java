package com.example.hello.leetcode;

public class No45Jump {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0; // 如果数组长度小于等于1，不需要跳跃
        }

        int maxReach = 0; // 当前能够到达的最远位置
        int steps = 0; // 步数

        int curReach = 0; // 当前位置能够到达的最远位置

        for (int i = 0; i < nums.length - 1; i++) { // 注意不需要遍历最后一个位置
            curReach = Math.max(curReach, i + nums[i]); // 更新当前位置能够到达的最远位置

            if (i == maxReach) { // 如果遍历到了当前能够到达的最远位置
                maxReach = curReach; // 更新最远位置为当前位置能够到达的最远位置
                steps++; // 增加步数
            }
        }

        return steps;
    }


}

package com.example.hello.leetcode;


public class No2765AlternativeSubArray {

    public static void main(String[] args) {
        int[] nums ={2,3,4,3,4};
        System.out.println(alternatingSubArray(nums));
    }

    public static int alternatingSubArray(int[] nums) {
        int ans = -1;
        int i = 0, n = nums.length;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                i++;//直接跳过
                continue;
            }
            int i0 = i;//记录这一组开始的位置
            i = i + 2;//i 和 i+1已经满足要求，从 i+2开始判断
            while (i<n && nums[i] == nums[i0] + (i-i0)%2){
                i++;
            }
            //从 i0到 i-1是满足题目要求的（并且无法再延长的）子数组
            ans =Math.max(ans,i -i0);
            i--;
        }
        return ans;
    }

}

package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1144MovesToMakeZigzag {
    public static void main(String[] args) {
        int[] nums = {2,1,2};
        System.out.println(movesToMakeZigzag(nums));

    }

        public static int movesToMakeZigzag(int[] nums) {
            int[] ans = new int[2];
            int n = nums.length;
            for (int i = 0; i < 2 ; ++i) {
                for (int j = i; j < n; j+=2) {
                    int d= 0;
                    if (j > 0){
                        d= Math.max(d,nums[j] - nums[j-1] +1);
                    }
                    if (j < n-1){
                        d = Math.max(d,nums[j] - nums[j+1] +1);
                    }
                    ans[i] += d;
                }
            }
            return Math.min(ans[0],ans[1]);
    }

}

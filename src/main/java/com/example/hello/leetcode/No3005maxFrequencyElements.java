package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No3005maxFrequencyElements {

    public static void main(String[] args) {
        int[] nums = {81,81,81,81,81,81,81,17,28,81,81,56,81,54,81,81,81,81,81,60,81,28,81,81,81,81,81,54,81,81,81,81,100,28};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
        int[] cvt =new int[101];
        for (int i = 0; i < nums.length ; i++) {
            cvt[nums[i]]++;
        }
        int maxValue =0;
        for (int i = 0; i <cvt.length ; i++) {
            maxValue=Math.max(maxValue,cvt[i]);
        }

        int res =0;
        for (int i = 0; i < cvt.length; i++) {
            if (cvt[i]==maxValue){
                res=res+maxValue;
            }
        }
        return res;
    }

}

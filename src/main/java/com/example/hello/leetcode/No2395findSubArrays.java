package com.example.hello.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 3/26/23 12:49
 */
public class No2395findSubArrays {

    public static void main(String[] args) {
        int[] nums = {4,2,4};
        System.out.println(findSubarrays(nums));
    }

    public static boolean findSubarrays(int[] nums) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i <nums.length-1; i++) {
                if (!sums.add(nums[i]+nums[i+1])){
                    return true;
                }
        }
        return false;
    }
}

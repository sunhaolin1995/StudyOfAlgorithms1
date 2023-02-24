package com.example.hello.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No2357minimumOperation {

    public static void main(String[] args) {

        int[] nums = {1,5,0,3,5};
        System.out.println(minimumOperations(nums));


    }

    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();


        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }
        return set.size();
    }

}

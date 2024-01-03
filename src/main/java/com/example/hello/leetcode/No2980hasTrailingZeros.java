package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No2980hasTrailingZeros {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        System.out.println(hasTrailingZeros(nums));
    }

    public static boolean hasTrailingZeros(int[] nums) {
        List<Integer> cvt = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String binaryString = Integer.toBinaryString(nums[i]);
            if (binaryString.endsWith("0")) {
                cvt.add(nums[i]);
            }
        }
        return cvt.size() >= 2;
    }

}

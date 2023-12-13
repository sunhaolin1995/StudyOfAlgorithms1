package com.example.hello.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No128LongestConsecutive {
    public static void main(String[] args) {
        int[] nums ={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }

        Set<Integer> cvt = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            cvt.add(nums[i]);
        }
        int res = 0;
        for (Integer num : cvt) {
            if (!cvt.contains(num-1)){
                int currentNum = num;
                int currentLength =1;

                while (cvt.contains(currentNum +1)){
                    currentNum++;
                    currentLength++;
                }
                res =Math.max(res,currentLength);
            }

        }
        return res;
    }

}

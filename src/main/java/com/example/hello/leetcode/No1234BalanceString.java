package com.example.hello.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 2/13/23 15:43
 */
public class No1234BalanceString {
    public static void main(String[] args) {
        String s = "WWEQERQWQWWRWWERQWEQ";

        System.out.println(balancedString(s));
    }

    public static int balancedString(String s) {
        int[] nums = {0,0,0,0};

        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == 'Q'){
                nums[0] = nums[0]+1;
            }
            if (s.charAt(i) == 'W'){
                nums[1] = nums[1]+1;
            }
            if (s.charAt(i) == 'E'){
                nums[2] = nums[2]+1;
            }
            if (s.charAt(i) == 'R'){
                nums[3] = nums[3]+1;
            }
        }

        int result = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[3]){
            Arrays.sort(nums);
            nums[0] = nums[0] + 1;
            nums[3] = nums[3] -1;
            result++;
            Arrays.sort(nums);
        }

        return result;

    }

}

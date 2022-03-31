package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date 2022/3/30 21:55 55
 */
public class No1twoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

         if (map.containsKey(target-nums[i])){
             return new int[]{map.get(target-nums[i]),i};
         }
            map.put(nums[i],i);
        }
         return new int[]{-1,-1};


    }

}

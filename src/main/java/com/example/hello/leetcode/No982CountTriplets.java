package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 3/4/23 11:12
 */
public class No982CountTriplets {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        System.out.println(countTriplets(nums));


    }

    public static int countTriplets(int[] nums) {
        //第二种做法，用空间换时间先讲前两个
        /*int[] ans = new int[1<<16];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length; j++) {
                ++ans[nums[i] & nums[j]];
            }
        }
        int res= 0;
        for (int i = 0; i < ans.length ; ++i) {
            for (int j = 0; j < nums.length ; j++) {
                if ((ans[i] & nums[j]) == 0){
                    res =ans[i]+res;
                }
            }
        }
        return res;*/

        /*int[] cnt = new int[1 << 16];
        for (int x : nums)
            for (int y : nums)
                ++cnt[x & y];
        int ans = 0;
        for (int x : nums)
            for (int y = 0; y < 1 << 16; y++)
                if ((x & y) == 0)
                    ans += cnt[y];
        return ans;*/
        Map<Integer, Integer> cnt =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                cnt.put((nums[i]&nums[j]), cnt.getOrDefault(nums[i]&nums[j],0)+1);
            }
        }
        int ans = 0;
        for (Integer firstTwoSum: cnt.keySet()) {
            for (int i = 0; i < nums.length; i++) {
                 if ((firstTwoSum&nums[i]) == 0){
                     ans=ans +cnt.get(firstTwoSum);
                 }
            }
        }
        return ans;
    }

    /*public static int countTriplets(int[] nums) {
        int res= 0;
        for (int i = 0; i <nums.length; i++) {
            for (int j = 0; j <nums.length ; j++) {
                for (int k = 0; k <nums.length ; k++) {
                    if ((nums[i]&nums[j] & nums[k]) == 0){
                        res = res+1;
                    }
                }
            }
        }
        return res;
    }*/

}

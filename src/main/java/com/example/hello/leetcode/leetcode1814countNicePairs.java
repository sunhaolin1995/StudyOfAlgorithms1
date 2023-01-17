package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode1814countNicePairs {

    public static void main(String[] args) {
        int[] nums = {42,11,1,97};
        System.out.println(countNicePairs(nums));

    }

    public static int countNicePairs(int[] nums) {
        int mod = (int)1e9+7;

        Map<Integer,Integer> mp=new HashMap<>();

        int ans = 0;

        for (int x: nums) {
            int rev = 0;
            for (int t = x; t !=0 ; t/=10) {
                rev = rev*10 + t%10;
            }
            ans = (ans +mp.getOrDefault(x-rev,0))%mod;
            mp.put(x - rev, mp.getOrDefault(x-rev,0)+1 );

        }
        return ans;
    }



}

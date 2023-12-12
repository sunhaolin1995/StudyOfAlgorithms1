package com.example.hello.leetcode;

import java.util.*;

/**
 * @author 孙浩林
 * @date: 12/12/23 21:15
 */
public class No219ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> cvt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cvt.containsKey(nums[i])) {
                List<Integer> integers = cvt.get(nums[i]);
                integers.add(i);
                cvt.put(nums[i], integers);
            } else {
                List<Integer> ints = new ArrayList<>();
                ints.add(i);
                cvt.put(nums[i], ints);
            }
        }

        int res =Integer.MAX_VALUE;
        for (int key:cvt.keySet()) {
            List<Integer> integers = cvt.get(key);
            if (integers.size()>=2){
                Object[] array =integers.toArray();
                Arrays.sort(array);
                for (int i = 0; i < array.length-1 ; i++) {
                    res = Math.min(res,(int)array[i+1]-(int)array[i]);
                }
            }

        }
        return res<= k;
    }
}

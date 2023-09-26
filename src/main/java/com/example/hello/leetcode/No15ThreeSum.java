package com.example.hello.leetcode;

import java.util.*;

public class No15ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] <0) {
                    left++;
                } else if (left != i  && right != i){
                    List<Integer> cvt = new ArrayList<>();
                    cvt.add(nums[left]);
                    cvt.add(nums[right]);
                    cvt.add(nums[i]);
                    res.add(cvt);
                    left++;
                }
                //更新指针left和right
                if (left == i){
                    left++;
                }
                if (right == i){
                    right--;
                }

            }
        }
        return new ArrayList<>(res);


       /* Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            int left = i+1,right = nums.length-1;
            while (left <right ){
                if (nums[i]+nums[left]+nums[right] == 0 ){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                } else if (nums[i]+nums[left]+nums[right] < 0 ) {
                    left++;
                } else if (nums[i]+nums[left]+nums[right] > 0 ) {
                    right--;
                }
            }
        }
        return new ArrayList<>(res);*/
    }

}

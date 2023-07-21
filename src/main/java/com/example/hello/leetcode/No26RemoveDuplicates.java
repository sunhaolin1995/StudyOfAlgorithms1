package com.example.hello.leetcode;


public class No26RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int p = 0, q = 1;
        while (q < nums.length ) {
            if (nums[p] == nums[q]){
                q++;
            } else if (nums[p] < nums[q]) {
                nums[p+1] = nums[q];
                p++;
                q++;
            }
        }
        return p+1;
    }

}

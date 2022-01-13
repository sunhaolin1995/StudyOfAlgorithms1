package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/13 8:57 下午
 */
public class No283MoveZero {
    public static int[] moveZeroes(int[] nums) {
        int i = 0,j = 0;
        for(i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while(j <  nums.length) {
            nums[j++] = 0;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums={1,0,2,0,13,4};
        int[] ints = moveZeroes(nums);
        for (int i = 0; i < ints.length ; i++) {
            System.out.println(ints[i]);
        }
    }
}

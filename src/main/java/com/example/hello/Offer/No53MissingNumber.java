package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/21/23 14:44
 */
public class No53MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int i = nums.length / 2;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i++;
        }
        return i;
    }

}

package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 3/4/23 11:12
 */
public class No982CountTriplets {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(countTriplets(nums));
    }

    public static int countTriplets(int[] nums) {
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
    }

}

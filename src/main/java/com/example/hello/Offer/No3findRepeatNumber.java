package com.example.hello.Offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 孙浩林
 * @date: 2022/7/20 22:07
 */
public class No3findRepeatNumber {
    public static void main(String[] args) {
        int[] nums ={2,3,1,0,2,3,5};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);

    }

    /*public static int findRepeatNumber(int[] nums){
        HashSet<Integer> set =new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
    return  -1;
    }*/

    public static int findRepeatNumber(int[] nums){

        for (int i = 0; i<nums.length ; i++) {
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }

        }

        return -1;
    }

    public static void exchangeNum(Integer num ){

    }

}

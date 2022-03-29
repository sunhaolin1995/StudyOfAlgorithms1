package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/3/7 10:09 下午
 */
public class jianZhiOffer03ShuZuZhongChongFuDeShuZi {
    public static void main(String[] args) {
        int[] num ={2,3,4,5,6,1,5,2};
        System.out.println(findRepeatNumber(num));
    }

    public static int findRepeatNumber(int[] nums){

            for (int i = 0; i <nums.length ; i++) {
             while(nums[i]!=i){
                     if (nums[i]==nums[nums[i]]){
                         return nums[i];
                     }
                     int temp =nums[i];
                     nums[i] =nums[temp];
                     nums[temp] =temp;
                 }
            }
        return -1;
    }
}

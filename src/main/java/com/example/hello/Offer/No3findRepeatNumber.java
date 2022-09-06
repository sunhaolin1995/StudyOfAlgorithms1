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


    //第一种方法 hashSet
    /*public static int findRepeatNumber(int[] nums){
        HashSet<Integer> set =new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
    return  -1;
    }*/

    //第二种方法 遍历数组然后交换
    /*public static int findRepeatNumber(int[] nums){

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
    }*/

    //第三种方法，递归
    public static int findRepeatNumber(int[] nums){
      int start =1;
      int end =nums.length-1;
      while (end >= start){
            int middle = ((end - start) / 2)+start;
            int count=countRange(nums,nums.length,start,middle);
            if (end==start){
               if (count>1){
                   return start;
               }else {
                   break;
               }
            }
            if (count >(middle-start)+1){
                end =middle;
            }else {
                start =middle+1;
            }

      }

        return -1;
    }

    private static int countRange(int[] nums, int length, int start, int end) {
         int count =0;
        for (int i = 0; i <length ; i++) {
            if (nums[i]>=start && nums[i]<=end ){
                ++count;
            }
        }
        return count;

    }

}

package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 孙浩林
 * @date 2022/3/22 22:49 49
 * 先排序在双指针成功
 */
public class No350Intersect {
    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,5,8,6,9};

    }


    public static int[] intersect(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        for (int i = 0, j = 0; i<nums1.length && j<nums2.length;){
           if (nums1[i]<nums2[j]){
               i++;
           }else if (nums1[i]>nums2[j]){
               j++;
           }else {
               list.add(nums1[i]);
               i++;
               j++;
           }
        }
        int[] nums3 =new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            nums3[i]=list.get(i);
        }
        return nums3;
    }



}

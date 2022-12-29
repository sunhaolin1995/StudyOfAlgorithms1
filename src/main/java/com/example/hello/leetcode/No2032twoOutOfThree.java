package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 2022/12/29 10:58
 */
public class No2032twoOutOfThree {
    public static void main(String[] args) {

    }

    public static List<Integer> twoOutOfThree(int[] nums1,int[] nums2 ,int[] nums3){

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length ; i++) {
            for (int j = 0; j < nums2.length ; j++) {
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }

        for (int i = 0; i < nums3.length ; i++) {
            for (int j = 0; j < nums2.length ; j++) {
                if (nums3[i] == nums2[j]){
                    set.add(nums3[i]);
                }
            }
        }

        for (int i = 0; i < nums1.length ; i++) {
            for (int j = 0; j < nums3.length ; j++) {
                if (nums1[i] == nums3[j]){
                    set.add(nums1[i]);
                }
            }
        }

        return new ArrayList<>(set);
    }

}

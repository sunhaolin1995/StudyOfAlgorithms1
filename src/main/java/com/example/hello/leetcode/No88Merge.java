package com.example.hello.leetcode;


import java.util.Arrays;

public class No88Merge {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

}

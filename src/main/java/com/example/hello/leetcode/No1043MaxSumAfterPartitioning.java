package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 4/19/23 10:50
 */
public class No1043MaxSumAfterPartitioning {

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0){
                    maxValue = Math.max(maxValue,arr[j-1]);
                }
            }
        }
        return d[n];
    }

}

package com.example.hello.leetcode;

import java.util.Arrays;

public class No2389AnswerQueries {

    public static void main(String[] args) {
        int[] nums = {4,5,2,1}, queries = {3,10,21};
        int[] ints = answerQueries(nums, queries);
        for (int s:ints) {
            System.out.println(s);
        }

    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + nums[i];
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(f, queries[i]) - 1;
        }
        return answer;
    }

    public static int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}

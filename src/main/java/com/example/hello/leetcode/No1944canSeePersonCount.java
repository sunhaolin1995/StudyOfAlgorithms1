package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1944canSeePersonCount {
    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] ints = canSeePersonsCount(heights);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque();
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek() < h) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(h);
        }
        return res;

    }

}

package com.example.hello.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No2283digitCount {
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
    }

    public static boolean digitCount(String num) {
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            h.put(digit, h.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int v = num.charAt(i) - '0';
            if (h.getOrDefault(i, 0) != v) {
                return false;
            }
        }
        return true;

    }
}

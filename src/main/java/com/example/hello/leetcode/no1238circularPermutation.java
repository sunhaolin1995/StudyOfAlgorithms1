package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class no1238circularPermutation {

    public static void main(String[] args) {

    }

    public static List<Integer> circularPermutation(int n, int start) {

        List<Integer> ret = new ArrayList<>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;

    }

}

package com.example.hello.leetcode;

public class No2182repeatLimitedString {

    static public void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        String string = repeatLimitedString(s, repeatLimit);
        System.out.println(string);
    }

    static public int N = 26;

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[N];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder ret = new StringBuilder();
        int m = 0;
        for (int i = N - 1, j = N - 2; i >= 0 && j >= 0; ) {
            if (count[i] == 0) {//当前字符已经填完，填入后面的字符，重置m
                m = 0;
                i--;
            } else if (m < repeatLimit) {//当前字符未超出限制
                count[i]--;
                ret.append((char) ('a' + i));
                m++;
            } else if (j >= i || count[j] == 0) {
                j--;
            } else {
                count[j]--;
                ret.append((char) ('a' + j));
                m = 0;
            }
        }
        return ret.toString();

    }

}

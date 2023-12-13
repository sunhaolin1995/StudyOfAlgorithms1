package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No2697MakeSmallestPalindrome {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(makeSmallestPalindrome(s));

    }

    public static String makeSmallestPalindrome(String s) {
        int length = s.length();
        char[] res = new char[length];
        if (length<=1){
            return s;
        }
        for (int i = 0; i < length-1; i++) {
            if (s.charAt(i) != s.charAt(length -1-i)){
                if (s.charAt(i)>s.charAt(length -1-i)){
                    res[i] = res[length -1-i] = s.charAt(length -1-i);
                }else {
                    res[i] = res[length -1-i] = s.charAt(i);
                }
            }else {
                res[i] = res[length -1-i] = s.charAt(i);
            }
        }
        return new String(res);
    }
}

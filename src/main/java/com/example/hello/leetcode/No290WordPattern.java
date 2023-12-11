package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 12/11/23 17:43
 */
public class No290WordPattern {

    public static void main(String[] args) {
        String pattern = "aaaa", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> cvt1 = new HashMap<>();
        Map<String, Character> cvt2 = new HashMap<>();

        String[] sSplit = s.split(" ");

        if (sSplit.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String sChar = sSplit[i];
            if ((cvt1.containsKey(patternChar) && !cvt1.get(patternChar).equals(sChar) ) || (cvt2.containsKey(sChar) && cvt2.get(sChar) != patternChar)) {
                return false;
            }
            cvt1.put(patternChar, sChar);
            cvt2.put(sChar, patternChar);
        }
        return true;
    }

}

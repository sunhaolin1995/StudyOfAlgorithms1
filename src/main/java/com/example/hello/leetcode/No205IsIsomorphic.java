package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 12/11/23 16:08
 */
public class No205IsIsomorphic {

    public static void main(String[] args) {

        String s = "bbbaaaba", t = "aaabbbba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> cvt1 = new HashMap<>();
        Map<Character, Character> cvt2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charA = s.charAt(i);
            char charB = t.charAt(i);

            if ((cvt1.containsKey(charA) && cvt1.get(charA) != charB) || (cvt2.containsKey(charB) && cvt2.get(charB) != charA)) {
                return false;
            }
            cvt1.put(charA, charB);
            cvt2.put(charB, charA);
        }
        return true;

    }


}

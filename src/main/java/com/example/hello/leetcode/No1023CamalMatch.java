package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 4/14/23 16:36
 */
public class No1023CamalMatch {
    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> booleans = camelMatch(queries, pattern);

        System.out.println(booleans.toString());

    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(isMatch(queries[i], pattern));
        }

        return res;
    }

    public static Boolean isMatch(String query, String pattern) {
        char[] queryArray = query.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int patternNum = 0;
        for (int i = 0; i < queryArray.length; i++) {
            char queryChar = queryArray[i];
            if ((patternNum < patternArray.length) && (queryChar == pattern.charAt(patternNum))) {
                patternNum++;
            } else if (Character.isUpperCase(queryChar)) {
                return false;
            }

        }
        if (patternNum < patternArray.length) {
            return false;
        }
        return true;

    }
}

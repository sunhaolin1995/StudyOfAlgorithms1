package com.example.hello.leetcode;

import java.util.HashMap;

/**
 * @author 孙浩林
 * @date: 9/27/23 16:42
 */
public class No3LengthOfLongestSubString {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res =0;
        HashMap cvt = new HashMap();
        for (right = 0; right <s.length() ; right++) {
            while (cvt.containsKey(s.charAt(right))){
                cvt.remove(s.charAt(left));
                left++;
            }
            cvt.put(s.charAt(right),s.charAt(right));
            res = Math.max(res,right-left+1);
        }
        return res;
    }


}

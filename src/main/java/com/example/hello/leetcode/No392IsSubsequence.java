package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/26/23 15:22
 */
public class No392IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()){
            return false;
        }
        int left = 0,right =0;
        while (left < s.length()){
            if (s.charAt(left) == t.charAt(right)){
                left++;
            }
            right++;
            if (right == t.length()){
                break;
            }
        }
        return left == s.length();
    }

}

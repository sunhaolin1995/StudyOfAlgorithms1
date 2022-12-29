package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/11/1 22:49
 */
public class No1662ArrayStringAreEqual {
    public static void main(String[] args) {
        String[] word1 = {"a", "cb"};
        String[] word2 = {"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1 , word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 ="" ,s2 = "";
        for (int i = 0; i <word1.length ; i++) {
            s1 = s1 + word1[i];
        }
        for (int i = 0; i <word2.length ; i++) {
            s2 = s2 + word2[i];
        }
        if (s1.length() != s2.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

}

package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/22/23 11:33
 */
public class No28StrStr {

    public static void main(String[] args) {
        String haystack = "abc", needle = "c";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {

        if (haystack.equals(needle)){
            return 0;
        }
        int res = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle)){
                if (res == -1){
                    res = i;
                }else {
                    return res;
                }
            }

        }
        return res;
    }

}

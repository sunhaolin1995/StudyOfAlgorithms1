package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/26/23 14:16
 */
public class No125IsPalindrome {

    public static void main(String[] args) {
        String s ="0P";
        System.out.println(isPalindrome(s));
        //System.out.println('z' == 122);
    }

    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        String convert = "";
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 97 && c <= 122) {
                convert = convert+c;
            }
            if (Character.isDigit(c)){
                convert = convert+c;
            }
        }
        for (int i = 0; i < convert.length()/2; i++) {
            if (convert.charAt(i)!= convert.charAt(convert.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}

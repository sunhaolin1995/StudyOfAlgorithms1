package com.example.hello.Algorithms.champerOne;

/**
 * 判断一个字符串是否为回文串
 * @author 孙浩林
 * @date: 2022/9/21 22:44
 */
public class No1_2_2_3String {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String s){
        int length = s.length();

        for (int i = 0; i <length/2 ; i++) {
            if (s.charAt(i)!=s.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}

package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/17/23 14:47
 */
public class No58ReverseLeftWords {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords(s,k));
    }
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()-1)+s.substring(0,n);
    }

}

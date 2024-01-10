package com.example.hello.leetcode;

public class No2696MinLength {
    public static void main(String[] args) {
        String s ="ABFCACDB";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")){
            s=s.replace("AB","");
            s=s.replace("CD","");
        }
        return s.length();
    }


}

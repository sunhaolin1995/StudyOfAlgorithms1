package com.example.hello.leetcode;

public class No2645addMinimum {

    public static void main(String[] args) {
        String word = "b";
        System.out.println(addMinimum(word));

    }

    public static int addMinimum(String word) {
        int res = word.charAt(0)-word.charAt(word.length()-1)+2;
        for (int i = 1; i <word.length() ; i++) {
            res =res+((word.charAt(i)-word.charAt(i-1)+2)%3);
        }
        return res;
    }
    /*public static int addMinimum(String word) {
        int t =1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i-1)){
                t++;
            }
        }
        return 3*t-word.length();
    }*/

    /*public static int addMinimum(String word) {
        int res = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            char ci = word.charAt(i);
            char ciNext = word.charAt(i + 1);
            if (ci == 'a') {
                if (ciNext == 'a') {
                    res = res + 2;
                } else if (ciNext == 'b') {

                } else if (ciNext == 'c') {
                    res = res + 1;
                }
            } else if (ci == 'b') {
                if (ciNext == 'a') {
                    res = res + 1;
                } else if (ciNext == 'b') {
                    res = res + 2;
                } else if (ciNext == 'c') {

                }
            } else if (ci == 'c') {
                if (ciNext == 'a') {

                } else if (ciNext == 'b') {
                    res = res + 1;
                } else if (ciNext == 'c') {
                    res = res + 2;
                }
            }
        }
        if (word.endsWith("a")) {
            res = res + 2;
        } else if (word.endsWith("b")) {
            res++;
        }
        while ((res + word.length() )% 3 != 0) {
            res++;
        }
        return res;
    }*/

}

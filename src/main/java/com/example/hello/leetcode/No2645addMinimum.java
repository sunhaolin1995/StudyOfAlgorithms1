package com.example.hello.leetcode;

public class No2645addMinimum {

    public static void main(String[] args) {
        String word = "b";
        System.out.println(addMinimum(word));

    }

    public static int addMinimum(String word) {
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
    }

}

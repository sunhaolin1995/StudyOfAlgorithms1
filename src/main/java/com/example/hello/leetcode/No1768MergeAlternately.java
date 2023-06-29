package com.example.hello.leetcode;

public class No1768MergeAlternately {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1,word2));
    }


    public static String mergeAlternately(String word1, String word2) {
        int lengthA = word1.length();
        int lengthB = word2.length();
        String res="";
        if (lengthA>=lengthB){
            String tail = word1.substring(lengthB,lengthA);
            for (int i = 0; i <lengthB ; i++) {
                res = res+word1.charAt(i)+word2.charAt(i);
            }
            res = res + tail;
        }
        if (lengthA<lengthB){
            String tail = word2.substring(lengthA,lengthB);
            for (int i = 0; i <lengthA ; i++) {
                res = res+word1.charAt(i)+word2.charAt(i);
            }
            res = res + tail;
        }

        return res;
    }

}

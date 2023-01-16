package com.example.hello.leetcode;

public class No1813areSentencesSimilar {

    public static void main(String[] args) {
        String sentence1 = "MTNhOb epj zqI dR", sentence2 = "MTNhOb epj dR";
        System.out.println(areSentencesSimilar(sentence1,sentence2));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {

        if (sentence1.length() > sentence2.length()){
            return areSentencesSimilar(sentence2,sentence1);
        }

        String[] sentence1Split = sentence1.split(" ");
        String[] sentence2Split = sentence2.split(" ");

        int left = 0 ,right=0;

        int m = sentence1Split.length,n = sentence2Split.length;

        while (left < m && sentence1Split[left].equals(sentence2Split[left])){
            left++;
        }
        while (right < m -left && sentence1Split[m - right -1].equals(sentence2Split[n-right-1]) ){
            right++;
        }

        return left + right == m;
    }
}

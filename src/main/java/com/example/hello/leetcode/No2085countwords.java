package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No2085countwords {

    public static void main(String[] args) {
        String[] words1 = {"a","ab"};
        String[] words2 = {"a","a","a","ab"};
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cvt1 = new HashMap<>();
        Map<String, Integer> cvt2 = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            cvt1.put(words1[i], cvt1.getOrDefault(words1[i], 0)+1);
        }
        for (int i = 0; i < words2.length; i++) {
            cvt2.put(words2[i], cvt2.getOrDefault(words2[i], 0)+1);
        }

        int res =0;

        for (String key:cvt1.keySet()){
            if (cvt1.get(key) == cvt2.get(key) && cvt1.get(key) == 1){
                res++;
            }
        }
        return res;
    }

}

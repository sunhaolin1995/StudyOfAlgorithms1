package com.example.hello.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 4/27/23 10:13
 */
public class No1048LongestStrChain {
    public static void main(String[] args) {
       String[] words = {"a","ba","b","bca","bda","bdca"};
       System.out.println(longestStrChain(words));


    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(num->num.length()));
        Map<String,Integer> d = new HashMap<>();

        int res =0;
        for (int i = 0; i <words.length ; i++) {
            int x = 0;
            for (int j = 0; j < words[i].length(); j++) {
                String s = words[i].substring(0,j)+words[i].substring(j+1);
                x = Math.max(x,d.getOrDefault(s,0)+1);
            }
            d.put(words[i], x);
            res = Math.max(res,x);
        }
        return res;
    }

}

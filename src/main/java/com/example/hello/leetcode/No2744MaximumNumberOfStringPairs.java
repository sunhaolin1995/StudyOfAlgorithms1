package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 1/17/24 08:44
 */
public class No2744MaximumNumberOfStringPairs {
    public static void main(String[] args) {
        String[] words = {"ff","tx","qr","zw","wr","jr","zt","jk","sq","xx"};
        System.out.println(maximumNumberOfStringPairs(words));

    }

    public static int maximumNumberOfStringPairs(String[] words) {
        int ans =0;
        boolean[][] cvt = new boolean[26][26];
        for (String s:words) {
            int x = s.charAt(0)-'a';
            int y = s.charAt(1)-'a';
            if (cvt[y][x]){
                ans++;
            }else {
                cvt[x][y]=true;
            }
        }
        return ans;
    }


    /*public static int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> cvt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
                cvt.put(words[i], cvt.getOrDefault(words[i],0)+1);
        }
        int res =0;
        for (String key: cvt.keySet()) {
            String newKey ="";
            newKey=newKey+key.charAt(1)+key.charAt(0);
            if (key.charAt(0)==key.charAt(1)){
                res=res+ (cvt.get(key)/2)*2;
            } else if (cvt.containsKey(newKey)){
                res =res+ Math.min(cvt.get(key),cvt.get(newKey));
            }
        }
        return res/2;
    }*/

}

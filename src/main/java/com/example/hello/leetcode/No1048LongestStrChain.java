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

    public static Map<String,Integer> ws = new HashMap<>();

    public static int longestStrChain(String[] words) {
        for (int i = 0; i < words.length; i++) {
            ws.put(words[i], 0 );
        }
        int res =0;

        for (String s :ws.keySet()) {
            res = Math.max(res,dfs(s));
        }

        return res;
    }

    public static int dfs(String s){
        int res = ws.get(s);
        if (res>0){
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0,i)+s.substring(i+1);
            if (ws.containsKey(s1)){
                res = Math.max(res,dfs(s1));
            }

        }
        ws.put(s,res+1);
        return res+1;
    }

}

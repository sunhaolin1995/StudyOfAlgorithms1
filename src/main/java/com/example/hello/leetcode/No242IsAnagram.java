package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 12/11/23 19:48
 */
public class No242IsAnagram {

    public static void main(String[] args) {
        String s = "a", t = "ab";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> cvt1 = new HashMap<>();
        Map<Character,Integer> cvt2 = new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {

            cvt1.put(s.charAt(i),cvt1.getOrDefault(s.charAt(i),0)+1);
            cvt2.put(t.charAt(i),cvt2.getOrDefault(t.charAt(i),0)+1);
            
        }

        for (Character ch:cvt1.keySet()) {
            cvt1.put(ch,cvt1.getOrDefault(ch,0)-cvt2.getOrDefault(ch,0));
            if (cvt1.get(ch)!= 0){
                return false;
            }
        }

        return true;

    }

}

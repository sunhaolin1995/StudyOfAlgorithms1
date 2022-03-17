package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date 2022/3/17 20:11 11
 */
public class N0387firstUniqChar {
    public static void main(String[] args) {
       String s ="dddccdbba";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public static int firstUniqChar(String s) {
        char[] chars =s.toCharArray();
        Map<Character,Integer> map =new HashMap<>(26);
        for (char ch: chars) {
            map.put(ch ,map.getOrDefault(ch,0)+1 );
        }
        for (int i = 0; i < chars.length; i++) {
             if (map.get(chars[i])==1){
              return i;
             }
        }
        /*for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }*/



       return -1;
    }


}

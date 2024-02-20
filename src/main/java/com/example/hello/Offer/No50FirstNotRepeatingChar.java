package com.example.hello.Offer;

import java.util.HashMap;
import java.util.Map;

public class No50FirstNotRepeatingChar {

    public static void main(String[] args) {
        String str = "npLByfdfoU";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> cvt = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            cvt.put(str.charAt(i), cvt.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (cvt.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /*public static int FirstNotRepeatingChar (String str) {
        Map<Character,Integer> cvt = new HashMap<>();
        int res =-1;
        Queue<Character> hasChar = new LinkedList<>();
        for (int i = 0; i <str.length() ; i++) {
            char key = str.charAt(i);
            Integer index = cvt.getOrDefault(key, 1);
            if (index ==1 && res ==-1){
                res =i;
                hasChar.add(key);
            } else if (index >1 && hasChar.peek() == key) {
                res=-1;
            }
            cvt.put(key, index +1);
        }

        return res;
    }*/

}

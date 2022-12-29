package com.example.hello.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 2022/10/11 19:14
 */
public class No1790areAlmostEqual {
    public static void main(String[] args) {

        System.out.println(areAlmostEqual("bank","kanb"));

    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Set<Character> characterSet1 = new HashSet<>();
        Set<Character> characterSet2 = new HashSet<>();
        for (int i = 0; i < char1.length ; i++) {
            if (char1[i] != char2[i]){
                boolean add1 = characterSet1.add(char1[i]);
                boolean add2 = characterSet2.add(char2[i]);
                if (!(add1 ||add2)){
                    return false;
                }
            }
        }
        if (characterSet1.size()==2&&characterSet2.size()==2){
            Iterator<Character> iterator1 = characterSet1.iterator();
            Iterator<Character> iterator2 = characterSet2.iterator();

            while (iterator1.hasNext()){
                if (!characterSet2.contains(iterator1.next())){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}

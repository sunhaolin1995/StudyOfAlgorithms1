package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 9/20/23 16:43
 */
public class No151reverseWords {

    public static void main(String[] args) {
        String s = "  hello world  ";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        List<String> convert = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals("")){
                convert.add(s1[i]);
            }
        }
        String res = "";
        for (int i = convert.size() - 1; i > 0; i--) {
            res =res+convert.get(i)+" ";
        }
        String lastString = convert.get(0);
        res =res + lastString;
        return res;
    }

}

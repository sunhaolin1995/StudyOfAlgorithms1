package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/18/23 11:12
 */
public class No58LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord(""));
    }

    public static int lengthOfLastWord(String s){
        String[] splits = s.split(" ");
        return splits[splits.length-1].length();
    }

}

package com.example.hello.leetcode;


/**
 * @author 孙浩林
 * @date 2022/3/28 12:54 54
 */
public class No14longestCommonPrefix {
    public static void main(String[] args) {
        //String[] strings = {"flower","flow","flight"};
        String[] strings = {"a"};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strings){
       if (strings.length==0){
           return "";
       }
       String prefix = strings[0];
       for (int i = 0; i < strings.length; i++) {
        while (strings[i].startsWith(prefix)==false){
            if (prefix.length()==0){
                return "";
            }
            prefix=prefix.substring(0,prefix.length()-1);
        }
       }
       return prefix;
    }

}

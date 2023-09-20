package com.example.hello.leetcode;


/**
 * @author 孙浩林
 * @date 2022/3/28 12:54 54
 */
public class No14longestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        //String[] strings = {"a"};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String compare = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] charArray = compare.toCharArray();
            int length = charArray.length;
            char[] charArrayStrings = strs[i].toCharArray();
            int length1 = charArrayStrings.length;
            compare = "";
            for (int j = 0; j < Math.min(length, length1); j++) {
                if (charArray[j] == charArrayStrings[j]) {
                    compare = compare + charArray[j];
                } else {
                    break;
                }
            }
        }
        return compare;











        /*
       if (strs.length==0){
           return "";
       }
       String prefix = strs[0];
       for (int i = 0; i < strs.length; i++) {
        while (strs[i].startsWith(prefix)==false){
            if (prefix.length()==0){
                return "";
            }
            prefix=prefix.substring(0,prefix.length()-1);
        }
       }
       return prefix;*/
    }

}

package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 1/29/23 10:42
 */
public class No2315CountAsterisks {
    public static void main(String[] args) {

    }


    public static int countAsterisks(String s) {

        boolean hasL = true;
        int result = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] =='|' ){
                hasL = !hasL;
            }
            if (hasL && charArray[i] == '*'){
                result++;

            }
        }

        return result;


    }


}

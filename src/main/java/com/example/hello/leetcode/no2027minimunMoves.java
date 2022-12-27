package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/12/27 14:16
 */
public class no2027minimunMoves {
    public static void main(String[] args) {

    }

    public static int minimumMoves(String s){

        int ans = 0,i=0;
        char[] chars = s.toCharArray();
        while (i < chars.length ){
            if (chars[i] == 'O'){
                i=i+1;
            } else if (chars[i] == 'X') {
                i=i+3;
                ans = ans+1;
            }
        }
        return ans;
    }

}

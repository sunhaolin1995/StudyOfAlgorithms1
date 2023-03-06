package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 3/6/23 17:12
 */
public class No1653MinimumDeletions {
    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }
    public static int minimumDeletions(String s) {

        int leftb =0 ,righta =0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == 'a'){
                righta++;
            }
        }

        int res = righta;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) =='a' ){
                righta--;
            }else {
                leftb++;
            }
            res = Math.min(res,righta+leftb);
        }
        return res;

    }

}

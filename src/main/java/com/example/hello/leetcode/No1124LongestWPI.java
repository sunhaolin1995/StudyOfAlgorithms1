package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2/14/23 10:11
 */
public class No1124LongestWPI {

    public static void main(String[] args) {
       int[] hours = {9,9,6,0,6,6,9};


    }

    public static int longestWPI(int[] hours) {
        int[] counts =new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            counts[i] = hours[i] - 8;
        }
        
    }

}

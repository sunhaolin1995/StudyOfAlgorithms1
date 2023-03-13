package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/3/30 5:34 下午
 */
public class No66plusOne {
    public static void main(String[] args) {
        int[]  digits = {8,9,9,9};
        int[] ints = plusOne(digits);
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] plusOne(int[] digits){
        for (int i = digits.length -1;i >=0 ; i--) {
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newres = new int[digits.length+1];
        newres[0]=1;
        return newres;

    }
}

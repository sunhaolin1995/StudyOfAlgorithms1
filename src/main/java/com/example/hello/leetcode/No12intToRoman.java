package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/18/23 09:51
 */
public class No12intToRoman {

    private static String res = "";

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
    }

    public static String intToRoman(int num) {

        while (true) {
            num = intToRomanNew(num);
            if (num == 0) {
                break;
            }
        }
        return res;

    }

    public static int intToRomanNew(int num) {
        if (num == 4) {
            res = res + "IV";
            return 0;
        }
        if (num == 9) {
            res = res + "IX";
            return 0;
        }
        if (num >= 40 && num < 50) {
            res = res + "XL";
            return num % 40;
        }
        if (num >= 90 && num < 100) {
            res = res + "XC";
            return num % 90;
        }
        if (num >= 400 && num < 500) {
            res = res + "CD";
            return num % 400;
        }
        if (num >= 900 && num < 1000) {
            res = res + "CM";
            return num % 900;
        }
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                res = res + "M";
            }

            return num % 1000;
        }
        if (num >= 500) {
            for (int i = 0; i < num / 500; i++) {
                res = res + "D";
            }
            return num % 500;
        }
        if (num >= 100) {
            for (int i = 0; i < num / 100; i++) {
                res = res + "C";
            }
            return num % 100;
        }
        if (num >= 50) {
            for (int i = 0; i < num / 50; i++) {
                res = res + "L";
            }
            return num % 50;
        }
        if (num >=10) {
            for (int i = 0; i < num / 10; i++) {
                res = res + "X";
            }
            return num % 10;
        }
        if (num >= 5) {
            for (int i = 0; i < num / 5; i++) {
                res = res + "V";
            }
            return num % 5;
        }
        if (num >= 1) {
            for (int i = 0; i < num / 1; i++) {
                res = res + "I";
            }
            return 0;
        }
        return 0;

    }


}

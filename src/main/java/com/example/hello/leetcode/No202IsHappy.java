package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 12/12/23 18:56
 */
public class No202IsHappy {

    public static void main(String[] args) {
        int n = 20;
       System.out.println(isHappy(n));
       /* for (int i = 0; i < 20; i++) {
            System.out.println(convert(n));
            n=convert(n);
        }*/
    }

    public static boolean isHappy(int n) {
        /*Map<Integer, Integer> cvt = new HashMap<>();
        cvt.put(n, n);*/
       // int fast = 0, slow = 1;
        int doubleN=n;
        while (true) {
            n=convert(n);
            doubleN = convert(convert(doubleN));
            if (convert(n)==1){
                return true;
            }
            if (n == doubleN){
                return false;
            }

        }
    }

    public static int convert(int n) {
        int res = 0;
        while (n >= 10) {
            String s = String.valueOf(n);
            int length = s.length() - 1;
            int subtract = (int) (Math.pow(10, length));
            int nowInt = n / subtract;
            n = n - nowInt * (subtract);
            res = res + nowInt * nowInt;
        }
        res = res + n * n;
        return res;
    }


}

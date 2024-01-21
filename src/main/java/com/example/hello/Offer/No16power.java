package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/21/24 16:06
 */
public class No16power {

    public static void main(String[] args) {
        System.out.println(Power(2.00, 3));

    }

    public static double Power(double base, int exponent) {
        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res = res * base;
        }
        return res;
    }


}

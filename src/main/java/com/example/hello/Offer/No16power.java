package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/21/24 16:06
 */
public class No16power {

    public static void main(String[] args) {
        System.out.println(Power(2.00, 0));
    }

    public static double Power(double base, int exponent) {
        //处理负数次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        return Pow(base, exponent);
    }

    private static double Pow(double x, int y) {
        double res = 1;
        while (y != 0) {
            //可以再往上乘一个
            if ((y & 1) != 0) {
                res = res * x;
            }
            //叠加
            x = x * x;
            y = y >> 1;
        }
        return res;
    }
    /***
     * 这个方法和上面的方法是等价的
     */
    /*private static double Pow(double x, int y) {
        double res = 1;
        while (y != 0) {
            if (y % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            y = y / 2;
        }
        return res;
    }*/

   /* public static double Power(double base, int exponent) {
        //处理负数次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res = res * base;
        }
        return res;
    }*/


}

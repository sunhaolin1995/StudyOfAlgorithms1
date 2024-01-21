package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/21/24 13:34
 */
public class No14cutRope {

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

    public static int cutRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[n];
        return max;
    }

}

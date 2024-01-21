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
                //第二个循环的意义是让两个长度相乘，所以 j<=i/2是为了避免重复计算，比如计算 34和 43，
                // j 从 1 开始是因为在第二个循环中模拟剪绳子，我们不需要记录剪下的长度为 0 的绳子
                int product = products[j] * products[i - j];
                products[i] = Math.max(max,product);
            }
        }
        max = products[n];
        return max;
    }

}

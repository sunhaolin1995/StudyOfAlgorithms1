package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/21/24 16:43
 */
public class No17printNumbers {

    public static void main(String[] args) {
        int[] ints = printNumbers(10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] printNumbers(int n) {
        int length = 1, i = 1;
        while (i <= n) {
            length = length * 10;
            i++;
        }
        int[] res = new int[length - 1];
        for (int j = 1; j <= res.length; j++) {
            res[j - 1] = j;
        }
        return res;
    }


}

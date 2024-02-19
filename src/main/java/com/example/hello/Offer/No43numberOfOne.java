package com.example.hello.Offer;

public class No43numberOfOne {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(100));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res = res + high * digit;
            } else if (cur == 1) {
                res = res + high * digit + low + 1;
            } else {
                res = res + (high + 1) * digit;
            }
            low = low + cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }

}

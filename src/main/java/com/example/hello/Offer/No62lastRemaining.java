package com.example.hello.Offer;

public class No62lastRemaining {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;

        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;

    }


}

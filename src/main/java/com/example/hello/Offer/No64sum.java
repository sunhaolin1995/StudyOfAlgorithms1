package com.example.hello.Offer;

public class No64sum {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }

    public static int Sum_Solution(int n) {
        //通过与运算判断n是否为正数，以结束递归
        boolean flag = (n > 1) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }

}

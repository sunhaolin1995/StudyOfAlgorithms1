package com.example.hello.Offer;

public class No65Add {

    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    public static int add(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (b !=0);

        return a;
    }

}

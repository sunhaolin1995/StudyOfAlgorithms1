package com.example.hello.Algorithms;


/***
 * 找出两个数字的最大公约数
 */
public class champterOne {
    public static void main(String[] args) {
        System.out.println(gcd(4,2));
    }

    public static int gcd(int p ,int q){
        if (q == 0){
            return p;
        }
        int r =p%q;
        return gcd(q,r);
    }

}

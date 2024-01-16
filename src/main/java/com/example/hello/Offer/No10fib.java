package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/2/23 19:53
 */
public class No10fib {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }


    public static int fib(Integer n){
        if (n <=0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n-1)+fib(n-2);

    }





}

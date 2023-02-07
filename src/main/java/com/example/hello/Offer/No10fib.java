package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/2/23 19:53
 */
public class No10fib {
    public static void main(String[] args) {
        System.out.println(fib(3));


    }

    public static int fib(int n) {
      if (n <2){
          return n;
      }

       int p = 0 , q =1 ,r =1;
        for (int i = 0; i < n -2 ; i++) {
            p = q;
            q=r;
            r = (p+q)%1000000007;
        }
      return r;
    }





}
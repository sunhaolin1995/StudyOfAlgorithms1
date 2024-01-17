package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/2/23 19:53
 */
public class No10fib {
    public static void main(String[] args) {
        System.out.println(fib(100));
    }


    public static int fib(Integer n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int p = 1, q = 0, res = 1;

        for (int i = 0; i < n - 2; i++) {
            q =p;
            p =res;
            res = p+q;
            //res = (p+q)%1000000007; //prevent stack over flow
        }
        return res;

    }


}

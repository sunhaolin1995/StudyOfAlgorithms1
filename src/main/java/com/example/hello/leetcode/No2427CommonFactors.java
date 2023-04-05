package com.example.hello.leetcode;

public class No2427CommonFactors {

    public static void main(String[] args) {
        int a = 12, b = 6;
        System.out.println(commonFactors(a,b));
    }
    public static int commonFactors(int a, int b) {
        int res = 0;
        for (int i = 1; i <=Math.min(a,b) ; i++) {
            if ((a %i) ==0 && (b%i) ==0){
                res++;
            }
        }
       return res;
    }

}

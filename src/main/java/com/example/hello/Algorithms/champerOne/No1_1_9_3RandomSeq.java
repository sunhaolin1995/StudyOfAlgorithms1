package com.example.hello.Algorithms.champerOne;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author 孙浩林
 * @date: 2022/9/17 14:36
 */
public class No1_1_9_3RandomSeq {
    public static void main(String[] args) {
        //打印N个（lo，hi）之间的随机值
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for (int i = 0; i <N ; i++) {
            double x = StdRandom.uniform(lo,hi);
            StdOut.printf("%.2f\n",x);
        }
    }
}

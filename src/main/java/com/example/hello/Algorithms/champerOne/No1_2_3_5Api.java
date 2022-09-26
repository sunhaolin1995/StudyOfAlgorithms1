package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * API。用例与实现
 * @author 孙浩林
 * @date: 2022/9/26 20:10
 */
public class No1_2_3_5Api {
    public static void main(String[] args) {
        int T = 1000000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0; t < T ; t++) {
            if (StdRandom.bernoulli(0.5)){
                heads.increment();
            }else {
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally() ;
        StdOut.println("delta: " +Math.abs(d));

    }
}

package com.example.hello.Algorithms.champerOne;

import com.example.hello.Algorithms.champerOne.pojo.VisualAccumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 可视化的累加器
 * @author 孙浩林
 * @date: 2022/9/26 20:32
 */
public class No1_2_4_4TestVisualAccumulator {
    public static void main(String[] args) {
        int T = 2000;
        VisualAccumulator a = new VisualAccumulator(T,1.0);
        for (int t = 0; t < T ; t++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}

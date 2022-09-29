package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包的经典用法
 * @author 孙浩林
 * @date: 2022/9/29 21:13
 */
public class No1_3_1_4Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        int i =0;
        while (!StdIn.isEmpty() && i <= 5 ){
            numbers.add(StdIn.readDouble());
            i++;
        }
        int N = numbers.size();
        double sum = 0.0;
        for (double x:numbers) {
            sum += x;
        }
        double mean = sum/N;
        sum = 0.0;
        for (double x: numbers) {
            sum += (x-mean)*(x+mean);
        }
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean: %.2f\n",mean);
        StdOut.printf("Std dev %.2f\n",std);


    }
}

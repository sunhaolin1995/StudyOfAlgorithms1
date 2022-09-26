package com.example.hello.Algorithms.champerOne.pojo;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author 孙浩林
 * @date: 2022/9/26 20:38
 */
public class VisualAccumulator extends Accumulator {
    private double total;

    private int N;

    public VisualAccumulator(int trials,double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val){
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
    }

    @Override
    public double mean() {
        return super.mean();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

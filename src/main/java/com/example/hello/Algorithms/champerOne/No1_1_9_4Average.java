package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author 孙浩林
 * @date: 2022/9/17 15:30
 */
public class No1_1_9_4Average {
    public static void main(String[] args) {
        //获取StrIn的所有数的平均值
        double sum =0;
        int cnt = 0 ;
        while (!StdIn.isEmpty()){
            sum += StdIn.readDouble();
            cnt++;
        }
        double average = sum/cnt;
        StdOut.printf("Average is %.2f\n",average);


    }
}

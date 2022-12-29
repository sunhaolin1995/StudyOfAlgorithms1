package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * StdIn类的静态方法的readInt()的实现
 * @author 孙浩林
 * @date: 2022/9/29 21:39
 */
public class No1_3_1_6readInts {
    public static void main(String[] args) {

    }
    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> q =new Queue<>();
        while (!in.isEmpty()){
            q.enqueue(in.readInt());
        }

        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N ; i++) {
            a[i] = q.dequeue();
        }

        return a;
    }

}

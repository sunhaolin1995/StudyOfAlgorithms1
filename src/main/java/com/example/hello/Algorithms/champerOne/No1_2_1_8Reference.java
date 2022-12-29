package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.Counter;

/**
 * java的引用的举例子说明
 *
 * @author 孙浩林
 * @date: 2022/9/21 20:48
 */

public class No1_2_1_8Reference {
    public static void main(String[] args) {
        Counter c1 =new Counter("ones");
        c1.increment();
        System.out.println(c1);
        Counter c2 =c1;
        c2.increment();
        System.out.println(c2);
        System.out.println(c1);
    }
}
/***
 * 输出结果
 * 1 ones
 * 2 ones
 * 2 ones
 */
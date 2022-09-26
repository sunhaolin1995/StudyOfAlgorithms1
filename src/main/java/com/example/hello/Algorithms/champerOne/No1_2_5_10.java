package com.example.hello.Algorithms.champerOne;

import com.example.hello.Algorithms.champerOne.pojo.Vector;

/**
 * 绕过final的不可见性
 * @author 孙浩林
 * @date: 2022/9/26 21:04
 */
public class No1_2_5_10 {
    public static void main(String[] args) {
        double[] a ={3.0,4.0};
        Vector vector = new Vector(a);
        vector.val();
        assert a[0]==3.0 : "hello";
        assert a[0]==0.0 : "hello";
        a[0] = 0.0;
        vector.val();

        assert a[0]==0 : "hello";
    }
}

package com.example.hello.Algorithms.champerOne.exercise;

/**
 * @author 孙浩林
 * @date: 2022/9/20 22:03
 */
public class No1_1_7 {
    public static void main(String[] args) {
        Double t =9.0;
        while (Math.abs(t-9.0/t)>.001){
            t=(9.0/t+t)/2.0;
            System.out.println(t);
        }
        System.out.println(.001);
    }
}

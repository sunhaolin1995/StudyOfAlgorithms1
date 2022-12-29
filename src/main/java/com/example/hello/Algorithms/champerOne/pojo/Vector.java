package com.example.hello.Algorithms.champerOne.pojo;

/**
 * @author 孙浩林
 * @date: 2022/9/26 21:02
 */
public  class Vector {

    private final double[] coords;

    public Vector(double[] a){
        coords =a;
    }

    public void val(){
        for (int i = 0; i <coords.length ; i++) {
            System.out.println(coords[i]);
        }
    }

}

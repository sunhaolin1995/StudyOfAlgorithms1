package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No447NumberOfBoomeranges {

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,int[]> cvt = new HashMap<>();

        for (int i = 0; i < points.length ; i++) {
            int[] cvt1 =new int[points.length];
            for (int j = 0; j < points.length ; j++) {
                cvt1[j] = Math.abs((points[j][0]-points[i][0])*(points[j][0]-points[i][0])
                +(points[j][1]-points[i][1])*(points[j][1]-points[i][1]) );
            }
            cvt.put(i,cvt1);
        }

        int res =0;
        for (int i = 0; i < cvt.size(); i++) {
            int[] ints = cvt.get(i);
            for (int j = 0; j < ints.length ; j++) {
                int anInt = ints[j];
                for (int k = 0; k <ints.length ; k++) {
                    if (j!= k && anInt == ints[k]){
                        res++;
                    }
                }
            }
        }
        return res;
    }

}

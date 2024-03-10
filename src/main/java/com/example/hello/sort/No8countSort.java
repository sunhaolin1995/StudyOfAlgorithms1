package com.example.hello.sort;

import java.util.Arrays;

public class No8countSort {
    public static void main(String[] args) {
        int[] num1 ={2,44,5,67,89,10};
        int[] sort = sort(num1);
        System.out.println("排序后的数组："+ Arrays.toString(sort));
    }

    public static int[] sort(int[] num1) {

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < num1.length; i++) {
            maxValue = Math.max(maxValue, num1[i]);
            minValue = Math.min(minValue, num1[i]);
        }

        int[] cvt = new int[maxValue - minValue+1];
        for (int i = 0; i <num1.length ; i++) {
            cvt[num1[i]-minValue]++;
        }

        int[] res = new int[num1.length];
        int index=0;
        for (int i = 0; i < cvt.length; i++) {
            while (cvt[i] != 0){
                res[index] = i+minValue;
                cvt[i]--;
                index++;
            }
        }
        return res;
    }


}

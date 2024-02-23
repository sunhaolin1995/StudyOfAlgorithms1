package com.example.hello.Offer;


import java.util.ArrayList;

public class No59maxInWindows {
    public static void main(String[] args) {
        int[] num = {10,14,12,11};
        int size = 0;
        ArrayList<Integer> integers = maxInWindows(num, size);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size ==0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= num.length - size; i++) {
            int maxValue = num[i];
            for (int j = 1; j < size; j++) {
                maxValue = Math.max(maxValue, num[j+i]);
            }
            res.add(maxValue);
        }
        return res;
    }

}

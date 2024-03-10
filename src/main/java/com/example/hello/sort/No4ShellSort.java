package com.example.hello.sort;

import java.util.Arrays;

public class No4ShellSort {

    public static void main(String[] args) {
        int[] num1 = {2, 44, 5, 67, 89, 10};
        ShellSort(num1);
        System.out.println(Arrays.toString(num1));
    }

    private static void ShellSort(int[] num1) {
        int gap = 1;
        while (gap < num1.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < num1.length; i++) {
                int temp = num1[i];
                int j = i - gap;
                while (j >= 0 && num1[j] > temp) {
                    num1[j + gap] = num1[j];
                    j = j - gap;
                }
                num1[j + gap] = temp;
            }
            gap = (int) Math.floor(gap/3);
        }

    }

}

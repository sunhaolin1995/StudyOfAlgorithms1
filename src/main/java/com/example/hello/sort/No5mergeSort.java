package com.example.hello.sort;

import java.util.Arrays;

public class No5mergeSort {

    public static void main(String[] args) {
        int[] num1 = {2, 44, 5, 67, 89, 10};
        int[] sort = sort(num1);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] num1) {
        if (num1.length < 2) {
            return num1;
        }
        return mergeSort(num1, 0, num1.length - 1);
    }

    private static int[] mergeSort(int[] num1, int left, int right) {
        if (left == right) {
            return new int[]{num1[left]};
        }
        int middle = (left + right) / 2;
        int[] leftArray = mergeSort(num1, left, middle);
        int[] rightArray = mergeSort(num1, middle + 1, right);
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, k = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }

        while (i < left.length) {
            res[k++] = left[i++];
        }
        while (j < right.length) {
            res[k++] = right[j++];
        }

        return res;
    }


}

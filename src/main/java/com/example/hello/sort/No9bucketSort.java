package com.example.hello.sort;

import java.util.Arrays;

public class No9bucketSort {
    public static void sort(int[] arr, int bucketSize) throws Exception {
        if (arr == null || arr.length == 0) {
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrAppend(int[] arr, int value) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = value;
        return newArr;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {29, 25, 15, 49, 37, 21, 43, 8, 12};
        sort(arr, 10);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

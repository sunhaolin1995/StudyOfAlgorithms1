package com.example.hello.sort;

/**
 * @author 孙浩林
 * @date: 2022/5/27 16:52
 */

import java.util.Arrays;

/**
 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，时间复杂度为O(n^2)。
 * 是稳定的排序方法。
 */
public class no1InsertionSort {
    public static void main(String[] args) {
       int[] num1 ={2,44,5,67,89,10};
       InsertionSort(num1);
        System.out.println("排序后的数组："+ Arrays.toString(num1));
    }


    public static void InsertionSort(int[] nums1){
        for (int i = 1; i < nums1.length ; i++) {
            int temp = nums1[i];
            int j = i-1;
            while (j>=0&&nums1[j]>temp){
                nums1[j+1]=nums1[j];
                j--;
            }
            nums1[j+1]=temp;

        }
    }

}

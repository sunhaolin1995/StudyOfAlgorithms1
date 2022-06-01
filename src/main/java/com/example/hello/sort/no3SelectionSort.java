package com.example.hello.sort;

/**
 * @author 孙浩林
 * @date: 2022/6/1 22:22
 */

/***
 *    选择排序(Selection sort)是一种简单直观的排序算法。
 *  * 它的工作原理是每一次从
 *  * 待排序的数据元素中选出最小(或最大)的一个元素，存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。
 *  * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。
 */

public class no3SelectionSort {
    public static void main(String[] args) {
        int[] num1 ={2,44,5,67,89,10};
        SelectionSort(num1);
    }

    public static void SelectionSort(int[] num1){
        int max=0;
        int k=0;
        for (int i = 0; i < num1.length ; i++) {
            if (max < num1[i]){
                max=num1[i];
            }
            k++;
        }

        for (int j = 0; j < num1.length; j++) {
            int temp;


        }


    }

}

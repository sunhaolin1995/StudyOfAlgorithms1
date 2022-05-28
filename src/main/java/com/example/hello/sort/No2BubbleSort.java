package com.example.hello.sort;

/**
 * @author 孙浩林
 * @date: 2022/5/28 11:07
 */

/**
 *冒泡排序（Bubble Sort，台湾译为：泡沫排序或气泡排序）是一种简单的排序算法。
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名。
 */
public class No2BubbleSort {
    public static void main(String[] args) {
        int[] num1 ={2,44,5,67,89,10};
        for (int i = 0; i < num1.length ; i++) {
            System.out.println(num1[i]);
        }
        BubbleSort(num1);
        for (int i = 0; i < num1.length ; i++) {
            System.out.println(num1[i]);
        }
    }

    public static void BubbleSort(int[] num1){
        for (int i = 0; i < num1.length-1; i++) {
            int atChange=0;
            for (int j = 0; j < num1.length-1-i; j++) {
                if (num1[j]<num1[j+1]){
                    exchangeElement(num1,j);
                    atChange=1;
                }
            }
            if (atChange==1){
                break;
            }
        }
    }


    public static void exchangeElement(int[] num1,int i){
        int temp =num1[i];
        num1[i] =num1[i+1];
        num1[i+1]=temp;
    }

}

package com.example.hello.sort;

/**
 * @author 孙浩林
 * @date: 2022/5/28 11:07
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
            for (int j = 0; j < num1.length-1; j++) {
                if (num1[j]<num1[j+1]){
                    exchangeElement(num1,j);
                }
            }
        }
    }


    public static void exchangeElement(int[] num1,int i){
        int temp =num1[i];
        num1[i] =num1[i+1];
        num1[i+1]=temp;
    }

}

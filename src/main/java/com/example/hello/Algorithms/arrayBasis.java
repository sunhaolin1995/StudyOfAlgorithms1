package com.example.hello.Algorithms;


import java.util.ArrayList;
import java.util.List;

/***
 * 数组的基本处理代码
 */
public class arrayBasis {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
        System.out.println(findMax(arr));
        System.out.println(findAvg(arr));
        System.out.println(copyArray(arr)[0]);
        System.out.println(reverseArray(arr)[0]);
    }
    /***
     * 找出数组中最大的元素
     */
    public static int findMax(int[] arr1){
        int a =  Integer.MIN_VALUE;
        for (int i = 0; i <arr1.length ; i++) {
            if (a <= arr1[i]){
                a =arr1[i];
            }
        }
       return a;
    }
    /***
     * 计算数组元素的平均值
     */
        public static int findAvg(int[] arr){
            int a =0;
            for (int i = 0; i <arr.length ; i++) {
                 a=a+arr[i];
            }
        return a/arr.length;
        }
    /***
     * 复制数组
     */
   public static int[] copyArray(int[] arr){
       int[] array =new int[arr.length];
       for (int i = 0; i < arr.length; i++) {
           array[i] =arr[i];
       }
     return array;
   }
    /***
     * 颠倒数组元素的顺序
     */
    public static int[] reverseArray(int[] arr){
        for (int i = 0; i <arr.length/2 ; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        return arr;
    }


}

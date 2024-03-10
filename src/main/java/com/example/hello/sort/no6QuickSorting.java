package com.example.hello.sort;

import java.util.Arrays;


/***
 * 从数列中挑出一个元素，称为 "基准"（pivot）;
 *
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class no6QuickSorting {
    public static void main(String[] args) {
        int[] num1 ={2,44,5,67,89,10};
        int[] sort = sort(num1);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] num1) {
        quickSort(num1, 0, num1.length - 1);
        return num1;
    }

    private static void quickSort(int[] num1, int left, int right) {
        if (left < right){
            int partitionIndex = partition(num1,left,right);
            quickSort(num1,left,partitionIndex-1);
            quickSort(num1,partitionIndex+1,right);
        }
    }

    private static int partition(int[] num1, int left, int right) {
        int pivot = num1[left];// 选取第一个元素作为基准值
        int i = left+1;
        int j = right;

        while (true){
            //从左边开始找到第一个大于基准值的元素的位置
            while ( i<= j && num1[i] <= pivot){
                i++;
            }
            //从右边开始在找到第一个小于基准值的元素的位置
            while (i <=j && num1[j] >= pivot){
                j--;
            }
            //如果i和j没有相遇，则交换他们找到的元素
            if (i <j){
                swap(num1,i,j);
            }else {
                break;//相遇时结束循环
            }
        }
        //将基准值放到正确的位置上
        swap(num1,left,j);
        return j;
    }

    private static void swap(int[] num1, int i, int j) {
        int temp = num1[i];
        num1[i] = num1[j];
        num1[j] = temp;
    }


}

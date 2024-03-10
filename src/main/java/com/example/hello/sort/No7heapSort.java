package com.example.hello.sort;

import java.util.Arrays;

public class No7heapSort {

    public static void main(String[] args) {
        int[] num1 = {2, 44, 5, 67, 89, 10};
        heapSort(num1);
        System.out.println(Arrays.toString(num1));
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;

        //构建最大堆
        buildMaxHeap(nums, len);
        //依次将堆顶元素和堆末尾元素交换，并调整堆结构
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);//将堆顶元素（最大值）和末尾元素交换
            adjustHeap(nums, 0, i);//调整堆结构，使得堆顶元素重新满足最大堆的性质
        }


    }

    private static void adjustHeap(int[] nums, int i, int len) {
        int temp = nums[i];//当前父节点的值
        int k = i * 2 + 1;//当前父节点的左子节点

        while (k < len) {
            if (k + 1 < len && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {//如果左右子节点存在比父节点大的值，则将较大的子节点与父节点交换
                nums[i] = nums[k];
                i = k;//更新父节点的索引，继续向下调整
                k = 2 * i + 1;//更新左子节点的索引
            } else {
                break;//如果父节点比左右节点都打，则调整结束
            }
        }
        nums[i] = temp;//将原父节点的值放到最终位置
    }

    private static void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }
    }

    // 交换数组中的两个元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

package com.example.hello.Offer;

import java.util.ArrayList;

public class No40getLeastNumbers {

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(input, 4);
        System.out.println(integers.toString());
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return result;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array,i+1,right);
        return i+1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    /*public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return result;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k,(a,b)->b-a);
        //遍历数组
        for (int num : input) {
            //如果堆的大小小于k，直接将元素加入堆中
            if (minHeap.size() < k){
                minHeap.offer(num);
            }else {
                //如果堆的大熊啊已经等于k，就将当前元素和堆顶元素进行比较
                //如果当前元素小于堆顶元素，则将堆顶元素替换为当前元素，并进行堆调整
                if (num< minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        //将堆中的元素放入结果数组中返回
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        return result;
    }*/


}

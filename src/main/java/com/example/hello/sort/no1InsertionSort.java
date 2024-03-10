package com.example.hello.sort;

/**
 * @author 孙浩林
 * @date: 2022/5/27 16:52
 */

import java.util.Arrays;

/**
 *
 * 排序算法是计算机科学中的基本算法之一，常见的排序算法包括以下十种：
 *
 * 冒泡排序（Bubble Sort）：依次比较相邻的两个元素，如果顺序错误则交换，直到没有需要交换的元素为止。
 *
 * 选择排序（Selection Sort）：每次从未排序的部分选择最小的元素，放到已排序部分的末尾。
 *
 * 插入排序（Insertion Sort）：依次将未排序部分的元素插入到已排序部分的合适位置。
 *
 * 希尔排序（Shell Sort）：改进的插入排序，将原序列分割成若干子序列，分别进行插入排序，然后逐步缩小子序列的间隔，最终完成排序。
 *
 * 归并排序（Merge Sort）：采用分治思想，将原序列分成若干子序列，分别排序后再合并。
 *
 * 快速排序（Quick Sort）：选取一个基准元素，将序列分成小于基准和大于基准的两部分，然后递归地对这两部分进行排序。
 *
 * 堆排序（Heap Sort）：利用堆这种数据结构进行排序，构建最大堆或最小堆，然后依次取出堆顶元素。
 *
 * 计数排序（Counting Sort）：统计序列中每个元素出现的次数，然后按照元素的值将其放置到正确的位置。
 *
 * 桶排序（Bucket Sort）：将原序列分到有限数量的桶中，对每个桶中的元素进行排序，然后按照桶的顺序将元素放回原序列。
 *
 * 基数排序（Radix Sort）：将待排序的元素按照个位、十位、百位等位数进行排序，每次排序根据某一位上的数字进行分配，直到所有位数排序完成。
 *
 * 每种排序算法都有其优缺点和适用场景，选择合适的排序算法取决于数据规模、数据分布情况以及排序性能的要求。
 *
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
            int j = i - 1;
            while (j >= 0 && nums1[j] > temp) {
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j + 1] = temp;
        }

    }


    /*public static void InsertionSort(int[] nums1){
        for (int i = 1; i < nums1.length ; i++) {
            int temp = nums1[i];
            int j = i-1;
            while (j>=0&&nums1[j]>temp){
                nums1[j+1]=nums1[j];
                j--;
            }
            nums1[j+1]=temp;

        }
    }*/

}

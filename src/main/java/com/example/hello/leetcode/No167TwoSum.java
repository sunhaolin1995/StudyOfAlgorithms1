package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/26/23 16:12
 */
public class No167TwoSum {

    public static void main(String[] args) {
        int[] numbers = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int target = 542;
        int[] ints = twoSum(numbers, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1; // 初始化右指针为数组末尾
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++; // 如果和小于目标值，移动左指针向右
            } else if (sum > target) {
                right--; // 如果和大于目标值，移动右指针向左
            } else {
                // 找到了满足条件的两个数，返回它们的索引（题目要求的索引从1开始）
                return new int[]{left + 1, right + 1};
            }
        }
// 如果没有找到满足条件的两个数，返回空数组或其他标志
        return new int[]{};


    }


}

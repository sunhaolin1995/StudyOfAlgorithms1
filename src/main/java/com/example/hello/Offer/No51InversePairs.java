package com.example.hello.Offer;

public class No51InversePairs {

    public static void main(String[] args) {
        int[] nums  ={9, 7, 5, 4, 6};
        System.out.println(InversePairs(nums));
    }


    public static int InversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    public static int reversePairs(int[] record, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPair = reversePairs(record, left, mid, temp);
        int rightPair = reversePairs(record, mid + 1, right, temp);

        if (record[mid] <= record[mid + 1]) {
            return leftPair + rightPair;
        }
        int crossPair = mergeAndCount(record, left, mid, right, temp);
        return leftPair + rightPair + crossPair;
    }

    public static int mergeAndCount(int[] record, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = record[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                record[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                record[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                record[k] = temp[i];
                i++;
            } else {
                record[k] = temp[j];
                j++;
                count = count + (mid - i + 1);
            }

        }
        return count;
    }

}

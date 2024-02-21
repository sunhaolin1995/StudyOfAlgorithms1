package com.example.hello.Offer;


public class no53Q2getMissingNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(getMissingNumber(nums));
    }

    public static int getMissingNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] != mid) {
                if (mid == 0 || (numbers[mid - 1] == mid - 1) || mid == numbers.length - 1) {
                    return mid;
                }
                right = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == numbers.length) {
            return numbers.length;
        }
        return -1;
    }

}

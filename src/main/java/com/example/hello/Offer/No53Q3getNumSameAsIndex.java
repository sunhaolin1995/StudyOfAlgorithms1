package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/21/24 17:43
 */
public class No53Q3getNumSameAsIndex {


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};

    }

    public static int GetNumberSameAsIndex(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > mid) {
                right = mid - 1;
            } else if (numbers[mid] < mid) {
                left = mid+1;
            }else {
                return mid;
            }

        }
        return -1;
    }

}

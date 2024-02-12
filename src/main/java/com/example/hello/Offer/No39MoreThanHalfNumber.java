package com.example.hello.Offer;

public class No39MoreThanHalfNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(numbers));
    }

    public static int MoreThanHalfNum_Solution(int[] numbers) {
        int candidate = 0;
        int count = 0;

        for (int num : numbers) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

        }
        return candidate;
    }
}

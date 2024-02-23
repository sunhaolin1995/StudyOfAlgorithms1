package com.example.hello.Offer;


import java.util.Arrays;

public class No61IsContinuous {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 5, 4};
        System.out.println(IsContinuous(numbers));
    }

    public static boolean IsContinuous(int[] numbers) {
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfSpace = 0;
        int i = 0;
        while (numbers[i] == 0) {
            numberOfZero++;
            i++;
        }
        for (; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            } else {
                numberOfSpace = numberOfSpace + (numbers[i + 1] - numbers[i] - 1);
            }
        }
        return numberOfZero >= numberOfSpace;
    }
}

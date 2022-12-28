package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2022/12/28 15:40
 */
public class No11minArray {
    public static void main(String[] args) {

    }

    public static int minArray(int[] numbers){
        int i =0,num = numbers[0],temp = 5000;
        while (i < numbers.length){
            if (numbers[i] < temp){
                num = numbers[i];
                temp = numbers[i];
            }
            i++;
        }
        return num;
    }

}

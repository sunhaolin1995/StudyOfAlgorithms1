package com.example.hello.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class No60printProbability {

    public static void main(String[] args) {

    }

    static int maxValue = 6;

    public static void printProbability(int number) {
        List<Map.Entry<Integer, Double>> res = new ArrayList<Map.Entry<Integer, Double>>();
        if (number <= 0) {
            return;
        }

        //这里一定要用long类型，不能用int型，数大了之后会造成int型溢出
        long[][] probabilities = new long[2][maxValue * number + 1];
        //数组转换标志
        int flag = 0;
        //用第一个骰子初始化数组
        for (int i = 1; i < maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int k = 2; k <= number; k++) {
            //清空不可能出现的位
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1-flag][i] =0;
                for (int j = 1; j <= i && j <= maxValue ; j++) {
                    probabilities[1-flag][i] = probabilities[1-flag][i] + probabilities[flag][i-j];
                }
            }
            flag =1-flag;
        }

        double total =Math.pow(maxValue,number);

    }

}

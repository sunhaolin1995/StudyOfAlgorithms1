package com.example.hello.leetcode;

public class No121maxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit =0;

        for (int i =0; i < prices.length ; i++) {
            if (prices[i] <= minPrice){
                minPrice = prices[i];
            }else {
                maxProfit =Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }

}

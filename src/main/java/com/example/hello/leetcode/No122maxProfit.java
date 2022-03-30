package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/3/29 10:58 下午
 */
public class No122maxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int price =0;
        for (int i = 0; i <prices.length-1 ; i++) {
          if (prices[i]<prices[i+1]){
              price+=prices[i+1]-prices[i];
          }
        }
        return price;
    }

}

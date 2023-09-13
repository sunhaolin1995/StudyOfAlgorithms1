package com.example.hello.leetcode;

import java.util.Arrays;

public class No135Candy {

    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
       int n = ratings.length;
       int[] candies = new int[n];
       Arrays.fill(candies,1);

       //从左到右遍历，确保右边评分更高的孩子获得更多的糖果
        for (int i = 1; i < n; i++) {
            if (ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        // 从右向左遍历，确保左边评分更高的孩子获得更多的糖果
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;


    }

}

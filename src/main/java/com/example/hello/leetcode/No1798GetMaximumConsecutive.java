package com.example.hello.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 孙浩林
 * @date: 2/4/23 13:16
 */
public class No1798GetMaximumConsecutive {

    public static void main(String[] args) {
        int[] coins = {1,1,1,4};
        System.out.println(getMaximumConsecutive(coins));
    }

    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        //这个是返回的结果
        int result = 1;

        for (int i = 0; i < coins.length ; i++) {
            if (coins[i] > result ){
                break;
            }else {
                result = result+coins[i];
            }
        }
        return result;
    }

}

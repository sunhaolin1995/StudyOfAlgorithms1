package com.example.hello.leetcode;

import java.util.Arrays;

/**
 * @author 孙浩林
 * @date: 1/22/24 08:43
 */
public class No670maximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }

    public static int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        String numStr = num + "";
        char[] charArray = numStr.toCharArray();

        char[] sortCharArray = Arrays.copyOf(charArray, charArray.length);
        Arrays.sort(sortCharArray);

        for (int i = 0; i < sortCharArray.length / 2; i++) {
            char temp = sortCharArray[i];
            sortCharArray[i] = sortCharArray[sortCharArray.length - 1 - i];
            sortCharArray[sortCharArray.length - 1 - i] = temp;
        }

        //先找到第一个要交换的位置
        int exchangeI = 0;
        for (int i = 0; i < sortCharArray.length ; i++) {
            if (charArray[exchangeI] == sortCharArray[exchangeI]){
                exchangeI=i;
            }else {
                break;
            }
        }


        int maxPosition = exchangeI;
        int maxChar = numStr.charAt(maxPosition) - '0';
        for (int i = exchangeI + 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) - '0' >= maxChar) {
                maxChar = Math.max(numStr.charAt(i) - '0', maxChar - '0');
                maxPosition = Math.max(i, maxPosition);
            }
        }
        //开始交换
        char tempFirst = numStr.charAt(exchangeI);
        char tempMaxPosition = numStr.charAt(maxPosition);
        String res = "";
        for (int i = 0; i < numStr.length(); i++) {
            if (i == exchangeI) {
                res = res + tempMaxPosition;
            } else if (i == maxPosition) {
                res = res + tempFirst;
            } else {
                res = res + numStr.charAt(i);
            }
        }
        return Integer.parseInt(res.toString());
    }

}

package com.example.hello.leetcode;

import java.util.Arrays;

/**
 * @author 孙浩林
 * @date: 9/11/23 13:17
 */
public class No274HIndex {

    public static void main(String[] args) {
        int[] citiations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citiations));

    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h){
                h++;
            }else {
                return h;
            }
        }
        return h;

    }

}

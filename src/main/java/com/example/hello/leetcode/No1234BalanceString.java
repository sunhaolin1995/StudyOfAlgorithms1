package com.example.hello.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 2/13/23 15:43
 */
public class No1234BalanceString {
    public static void main(String[] args) {
        String s = "WWEQERQWQWWRWWERQWEQ";

        System.out.println(balancedString(s));
    }


    //我认为我的做法是对的，但是题解要求用滑动窗口做，所以没办法
   /* public static int balancedString(String s) {
        int[] nums = {0,0,0,0};

        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == 'Q'){
                nums[0] = nums[0]+1;
            }
            if (s.charAt(i) == 'W'){
                nums[1] = nums[1]+1;
            }
            if (s.charAt(i) == 'E'){
                nums[2] = nums[2]+1;
            }
            if (s.charAt(i) == 'R'){
                nums[3] = nums[3]+1;
            }
        }

        int result = 0;
        Arrays.sort(nums);
        while (nums[0] != nums[3]){
            Arrays.sort(nums);
            nums[0] = nums[0] + 1;
            nums[3] = nums[3] -1;
            result++;
            Arrays.sort(nums);
        }
        return result;
    }*/

    public static int balancedString(String s){
        int[] counts = new int[26];
        int len = s.length();
        int limit = len/4;

        char ch;

        //初始化不替換内容字符出現次數數組，即滑動窗口維護一個空串
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            counts[ch - 'A']++;
        }
        // 初始化滑动窗口左右指针，维护的子串是[left,right]的内容
        // 初始化子串为空，因此left=0，right=-1表示一个空子串
        int left = 0;
        int right =-1;
        int minLength = len;//

        while (left < len){
            //校驗通過
            //記錄當前合法子串長度并更新最小長度
            if (check(counts,limit)){
               //左指針右移
                minLength = Math.min(minLength,right-left+1);
                counts[s.charAt(left++) - 'A']++;
            } else if (right < len -1 ) {
                counts[s.charAt(++right) - 'A'] --;
            }else {
                break;
            }
        }



     return minLength;




    }

    /**
     * 校验函数，校验当前counts中四个字符的出现次数是否都小于等于limit；
     * 是返回true，否返回false
     */
    private static boolean check(int[] counts, int limit){
        if(counts['Q' - 'A'] > limit || counts['W' - 'A'] > limit || counts['E' - 'A'] > limit || counts['R' - 'A'] > limit){
            return false;
        }
        return true;
    }




}

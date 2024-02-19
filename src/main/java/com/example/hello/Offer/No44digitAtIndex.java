package com.example.hello.Offer;

public class No44digitAtIndex {

    public static void main(String[] args) {
        System.out.println(findNthDigit(3000));
    }

    public static int findNthDigit(int n) {
        //记录n是几位数
        int digit =1;
        //记录当前位数区间的初始数字，1，10，100
        long start =1;
        //记录当前区间之间总共有多少数字
        long sum =9;
        //将n定位到某个位数的区间中
        while (n > sum){
            n = (int) (n- sum);
            start = start*10;
            digit++;
            //该区间的总共位数
            sum =9*start*digit;
        }
        //定位n在哪个数字的哪一位上
        String num = "" +(start + (n-1)/digit);
        //定位n在数字的哪一位上
        int index =(n-1)%digit;
        return (int)(num.charAt(index) - (int)('0'));



    }



}

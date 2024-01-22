package com.example.hello.Offer;

import java.util.Date;

/**
 * @author 孙浩林
 * @date: 1/21/24 16:43
 */
public class No17printNumbers {

    public static void main(String[] args) {
        /*int[] ints = printNumbers(8);
        long before = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        long after = System.currentTimeMillis();
        System.out.println(after-before);*/
        printToMaxOfDigits(1);
    }


    //打印1到最大的n位数
    public static void printToMaxOfDigits(int n){
        if(n <= 0){
            System.out.println("输入的n没有意义");
            return;
        }
        //声明字符数组,用来存放一个大数
        char number[] = new char[n];
        for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
            number[i] = '0';
        }
        while(!incrementNumber(number)){ //如果大数自加，直到自溢退出
            printNumber(number); //打印大数
        }
    }

    //自加
    private static boolean incrementNumber(char[] number) {
        boolean isOverflow = false; //判断是否溢出
        int nTakeOver = 0; //判断是否进位
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0 ; --i) {
            int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
            if(i == nLength - 1){ //末尾自加1
                ++nSum;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;
                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }else{
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    //打印数字
    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /*public static int[] printNumbers(int n) {
        int length = 1, i = 1;
        while (i <= n) {
            length = length * 10;
            i++;
        }
        int[] res = new int[length - 1];
        for (int j = 1; j <= res.length; j++) {
            res[j - 1] = j;
        }
        return res;
    }*/


}

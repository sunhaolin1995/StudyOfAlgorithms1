package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/21/24 14:39
 */
public class N015NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(5345345));
    }

    public static int NumberOf1(int n) {
        int res = 0;
        //遍历 32位
        for (int i = 0; i < 32; i++) {
            // 按位比较
            if ((n & (1 << i))!= 0){
                res++;
            }
        }
        return res;
    }


}

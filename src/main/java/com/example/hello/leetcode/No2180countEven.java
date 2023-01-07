package com.example.hello.leetcode;

public class No2180countEven {
    public static void main(String[] args) {
        System.out.println(countEven(896));
    }

    public static int countEven(int num) {
        int result =0;
        for (int i = 1; i <= num; i++) {
            if (i <10){
                if (i%2==0){
                    result++;
                }
            }
             else if(i >=10 && i <100){
                if (((i%10)+ i/10)%2 ==0 ){
                    result++;
                }

            } else if (i >= 100 && i <1000) {
                if ((i/100 + (i/10)%10 +i%100 )%2 ==0 ){
                    result++;
                }
            }
        }
        return result;
    }
}

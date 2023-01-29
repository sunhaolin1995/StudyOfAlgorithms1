package com.example.hello.leetcode;

public class No1664waysToMakeFair {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        System.out.println(waysToMakeFair(nums));
    }

    public static int waysToMakeFair(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length ; i++) {

            if (checkIsBalance(nums,i)){
              result++;
            }

        }

        return result;
    }

    public static boolean checkIsBalance(int[] num,int index){
        if (num.length == 2){
            if (num[0] == num[1]){
                return true;
            }else {
                return false;
            }
        }
        int leftSum=0,rightSum = 0;
        int[] newNum = new int[num.length-1];
        for (int i = 0; i <num.length ; i++) {
            if (i < index){
                newNum[i] = num[i];
            } else if (i > index) {
                newNum[i-1] = num[i];
            }
        }

        for (int i = 0; i < newNum.length ; i++) {
            if (i % 2 == 0){
                leftSum = leftSum+newNum[i];
            }
            if (i % 2 == 1){
                rightSum = rightSum + newNum[i];
            }
        }


        return leftSum == rightSum ;
    }


}

package com.example.hello.Offer;

public class No42FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array={1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray (int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int curSum =0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum<=0){
                curSum = array[i];
            }else {
                curSum =curSum+array[i];
            }
            maxSum =Math.max(curSum,maxSum);
        }
        return maxSum;
    }

}

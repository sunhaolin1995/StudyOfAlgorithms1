package com.example.hello.leetcode;

public class No2293minMaxGame {

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,4,8,2,2};
        System.out.println(minMaxGame(nums));
    }


    public static int minMaxGame(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] arr=new int[n/2];
        for(int i=0;i<n/2;i++){
            if((i&1)==0){
                arr[i]=Math.min(nums[2*i],nums[2*i+1]);
            }else{
                arr[i]=Math.max(nums[2*i],nums[2*i+1]);
            }
        }
        return minMaxGame(arr);
    }

}

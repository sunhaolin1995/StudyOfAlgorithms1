package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/7 10:54 下午
 */
public class No485findMaxConsecutiveOnes {


    public static void main(String[] args) {
        int[] nums ={1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int a =0,b=0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]==1){
                a++;
            }
            if (nums[i]==0 || i== nums.length-1){
                if (a>=b){
                    b=a;
                }
                a=0;
            }
        }
        return b;
    }

}

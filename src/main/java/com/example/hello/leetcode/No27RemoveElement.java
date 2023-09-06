package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/13 10:56 下午
 */
public class No27RemoveElement {


    public static void main(String[] args) {
        int[] num = {3,2,2,3};
        int i = removeElement(num, 3);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int leftNum = 0,rightNum = nums.length-1;
        while (leftNum <= rightNum){
            if (nums[leftNum] == val){
                nums[leftNum] = nums[rightNum];
                rightNum--;
            }else {
                leftNum++;
            }
        }
        return leftNum;

        /*int a=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=val){
                nums[a]= nums[i];
                a++;
            }
        }
        return a;*/
        /*while (a< nums.length){
            nums[a++]=0;
        }*/
       /* if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;*/
    }

}

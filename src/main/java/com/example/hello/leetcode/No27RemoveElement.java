package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/13 10:56 下午
 */
public class No27RemoveElement {


    public static void main(String[] args) {
        int[] num ={0,1,2,2,3,0,4,2};
        int i = removeElement(num, 2);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int a=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=val){
                nums[a]= nums[i];
                a++;
            }
        }
        /*while (a< nums.length){
            nums[a++]=0;
        }*/
        return a;
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

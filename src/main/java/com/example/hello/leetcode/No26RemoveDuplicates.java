package com.example.hello.leetcode;


public class No26RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static int removeDuplicates(int[] nums) {

        int leftNum = 0,rightNum = 1;
        while(rightNum<nums.length){
            if (nums[leftNum] == nums[rightNum]){
                rightNum++;
            }else {
                //exchange rightNum and rightNum+1
                int temp = nums[leftNum+1];
                nums[leftNum+1] =nums[rightNum];
                nums[rightNum] =temp;
                rightNum++;
                leftNum++;
            }
        }

        return leftNum+1;












        /*int p = 0, q = 1;  2023.07.21
        while (q < nums.length ) {
            if (nums[p] == nums[q]){
                q++;
            } else if (nums[p] < nums[q]) {
                nums[p+1] = nums[q];
                p++;
                q++;
            }
        }
        return p+1;*/
    }

}

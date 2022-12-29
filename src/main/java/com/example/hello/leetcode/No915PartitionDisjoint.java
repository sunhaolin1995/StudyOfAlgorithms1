package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/10/24 19:56
 */
public class No915PartitionDisjoint {
    public static void main(String[] args) {
      int[]  nums ={5,0,3,8,6};
        System.out.println(partitionDisjoint(nums));
    }

    public static int partitionDisjoint(int[] nums) {
        int leftMax = nums[0] , leftPos = 0 , curMax = nums[0] ;
        for (int i = 0; i < nums.length-1; i++) {
          curMax = Math.max(curMax,nums[i]);
          if (nums[i] < leftMax){
            leftMax = curMax ;
            leftPos = i;
          }
        }
      return leftPos+1;
    }

}

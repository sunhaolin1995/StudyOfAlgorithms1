package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 4/20/23 13:11
 */
public class No300lengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }


    public static int lengthOfLIS(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int x: nums) {
           int j = lowerBound(g,x);
           if (j == g.size()){
               g.add(x);
               // >=x的g[j]不存在
           }else {
               g.set(j,x);
           }
        }
        return g.size();
    }

    public static int lowerBound(List<Integer> g,int target){
        int left = -1 ,right = g.size();//开区间left，right
        while (left+1 < right){//区间不为空
            //循环不变量 nums[left] < target  nums[left] >= target
            int mid = (left + right) >>>1;
            if (g.get(mid) < target){
                left  =mid;
            }else {
                right = mid;
            }

        }
        return right;
    }



    /*public static int[] nums,memo;
    public static int lengthOfLIS(int[] num) {
        nums = num;
        int n = nums.length;
        memo = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,dfs(i));
        }
        return ans;
    }

    public static int dfs(int i){
        if (memo[i]>0){
            return memo[i];
        }
        for (int j = 0; j <i ; j++) {
            if (nums[j] < nums[i]){
                memo[i] = Math.max(memo[i],dfs(j));
            }
        }
        return ++memo[i];
    }*/


}

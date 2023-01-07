package com.example.hello.leetcode;

import java.util.Arrays;

public class No1658minOperations {
    public static void main(String[] args) {
       int[] nums = {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639
			};

       int x = 565610;
        System.out.println(minOperations(nums,x));
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x){
            return -1;
        }
        int right =0;
        int lsum = 0,rsum = sum;
        int ans = n+1;

        for (int left = -1; left < n; ++left) {
            if (left != -1){
                lsum = lsum +nums[left];
            }

            while (right <n && lsum +rsum >x){
                rsum = rsum - nums[right];
                ++right;
            }
            if (lsum +rsum ==x){
                ans = Math.min(ans,(left+1) +(n-right));
            }
        }
      return ans >n ? -1 :ans;
    }


    /*public static int minOperations(int[] nums, int x) {
        int result= 0;
        int left=0,right = nums.length-1;

        int sum=0;
        for (int i = 0; i < nums.length ; i++) {
            sum = sum+nums[i];
        }
        if (sum < x){
            return -1;
        }

        while (x >0){
           if (nums[left]>nums[right]){
               if (x - nums[left] >=0){
                   x = x -nums[left];
                   left = left+1;
                   result++;
               }else if (x - nums[right] >=0){
                   x = x -nums[right];
                   right = right -1;
                   result++;
               }else {
                   break;
               }
           }else if (nums[left] <= nums[right]){
               if (x - nums[right] >=0){
                   x = x -nums[right];
                   right = right -1;
                   result++;
               }else if (x - nums[left] >=0){
                   x = x -nums[left];
                   left = left+1;
                   result++;
               }else {
                   break;
               }
           }
           if (result ==0){
               break;
           }
        }

        if (x == 0){
            return result;
        }
        return -1;
    }*/

}

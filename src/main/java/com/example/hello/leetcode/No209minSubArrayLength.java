package com.example.hello.leetcode;

public class No209minSubArrayLength {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = nums[0], minLeng = Integer.MAX_VALUE;
        while (left <= right) {
            if (sum < target) {
                if (right < nums.length - 1) {
                    right++;
                    sum = sum + nums[right];
                } else {
                    sum = sum - nums[left];
                    left++;
                }
            } else if (sum >= target) {
                minLeng = Math.min(minLeng, right - left+1);
                sum = sum - nums[left];
                left++;
            }
        }

        if (minLeng == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLeng;
        }

      /*  int left = 0, right = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            if (sum < target) {
                right++;
                if (right < nums.length) {
                    sum = sum + nums[right];
                }
            } else if (sum > target) {
                sum = sum - nums[left];
                left++;
            } else if (sum == target) {

                res = Math.min(res, right - left);
                sum = sum - nums[left];
                left++;
            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        } else {
            return res;
        }*/
    }
    /*题目要求找到给定数组中和大于等于目标值的最短子数组的长度。
    一种常用的解题思路是使用滑动窗口。我们使用两个指针 left 和 right 表示滑动窗口的左右边界。
    初始时，将 left 和 right 都指向数组的第一个元素。然后，我们不断尝试向右移动右指针 right，并更新滑动窗口中元素的和。如果当前的和小于目标值，则继续向右移动右指针，并更新和。
    如果当前的和大于等于目标值，则更新最短子数组的长度，并尝试向右移动左指针 left，并更新和。
    在移动左指针 left 之前，我们需要记录当前的最短子数组长度。为此，我们可以使用一个变量 minLen 来存储当前的最小长度。初始时，可以将 minLen 设置为一个足够大的值，比如数组的长度加一。
    当右指针 right 移动到数组的末尾时，我们就完成了一轮滑动窗口的遍历。我们可以继续尝试向右移动左指针 left，并更新和，直到和小于目标值。
    在移动左指针 left 的过程中，我们需要不断更新最小子数组的长度 minLen。最后，我们返回最小子数组的长度 minLen。
    这种解题思路的时间复杂度是 O(N)，其中 N 是数组的长度。因为每个元素最多被访问两次（一次作为右指针，一次作为左指针），而指针的移动是单向的，因此总的时间复杂度是线性的。*/


}

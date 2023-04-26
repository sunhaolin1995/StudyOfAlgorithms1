package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 4/26/23 11:22
 */
public class No031MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen = 3, secondLen = 4;
        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
        System.out.println(test(nums, firstLen, secondLen));

    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0, maxSumA = 0, maxSumB = 0;
        for (int i = firstLen + secondLen; i < n; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB, s[i - firstLen] - s[i - firstLen - secondLen]);
            ans = Math.max(ans, Math.max(maxSumA + s[i] - s[i - secondLen],
                    maxSumB + s[i] - s[i - firstLen]));
        }
        return ans;

    }

    public static int test(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + nums[i]; // 计算 nums 的前缀和
        int ans = 0, maxSumA = 0, maxSumB = 0;
        for (int i = firstLen + secondLen; i <= n; ++i) {
            maxSumA = Math.max(maxSumA, s[i - secondLen] - s[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB, s[i - firstLen] - s[i - firstLen - secondLen]);
            ans = Math.max(ans, Math.max(maxSumA + s[i] - s[i - secondLen],  // 左 a 右 b
                    maxSumB + s[i] - s[i - firstLen])); // 左 b 右 a
        }
        return ans;
    }

}

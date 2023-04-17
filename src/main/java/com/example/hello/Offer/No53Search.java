package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/17/23 16:08
 */
public class No53Search {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        // 思路：二分找到最左边的，再次二分找到最右边的
        int left = 0, right = nums.length - 1;

        // 寻找最左边的数的index
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {   // 如果当前值和target相等，就还继续往左找，因为要找到出现的最左边位置
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // right是第一次出现的位置 用l记录一下
        int l = right;
        // 如果right位置上不是target 提前说明没有target 直接返回0
        if (nums[right] != target) {
            return 0;
        }
        right = nums.length - 1;    // left不用为0就行，只用将right值调整，再次二分
        while (left < right) {
            /**
             (left + right + 1) / 2;
             此处如果是四舍五入，当left和right相差1的时候，会陷入死循环，
             left 3 right 4
             mid = 3 left = mid = 3
             继续循环
             这种死循环会出现在 left右移并且要=mid的时候
             */
            int mid = (left + right + 1) / 2;   // 此处+1作用 mid进一 而不是四舍五入
            if (nums[mid] <= target) {    //  要找最右边的，所以mid位置上和target相等就继续往右找
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right - l + 1;
    }

}

package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/21/23 14:44
 */
public class No53MissingNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        System.out.println(GetNumberOfK(nums, k));
    }

    public static int GetNumberOfK(int[] nums, int k) {
        int number = 0;
        if (nums != null && nums.length > 0) {
            int first = getFirstK(nums, k, 0, nums.length - 1);
            int last = getLastK(nums, k, 0, nums.length - 1);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    private static int getFirstK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < k) {
            return getFirstK(nums, k, mid + 1, end);
        } else {
            return getFirstK(nums, k, start, mid - 1);
        }
    }

    private static int getLastK(int[] nums, int k, int start, int end) {
        if (start > end) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] <= k) {
            return getLastK(nums, k, mid + 1, end);
        } else {
            return getLastK(nums, k, start, mid - 1);
        }
    }


    /*public static int getFirstK(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < k) {
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    public static int getLastK(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
*/

/*
    public static int getFirstK(int[] nums, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = start + (end - start) / 2; // 避免溢出
        int middleNum = nums[middleIndex];
        if (middleNum == k) {
            if ((middleIndex > 0 && nums[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleNum > k) {
            end = middleIndex - 1;
        } else {
            end = middleIndex + 1;
        }
        return getFirstK(nums, length, k, start, end);
    }

    public static int getLastK(int[] nums, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = start + (end - start) / 2; // 避免溢出
        int middleNum = nums[middleIndex];
        if (middleNum == k) {
            if ((middleIndex < length - 1 && nums[middleIndex + 1] != k) || middleIndex == length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleNum < k) {
            start = middleIndex + 1;
        } else {
            start = middleIndex - 1;
        }
        return getLastK(nums, length, k, start, end);
    }*/

}

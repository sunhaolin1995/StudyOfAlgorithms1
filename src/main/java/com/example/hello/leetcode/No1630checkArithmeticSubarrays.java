package com.example.hello.leetcode;

import java.util.*;


public class No1630checkArithmeticSubarrays {

    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, l = {0,1,6,4,8,7}, r = {4,4,9,7,9,10};
        List<Boolean> booleans = checkArithmeticSubarrays(nums, l, r);
        for (Boolean res : booleans) {
            System.out.print(res + ",");
        }
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] convert = new int[r[i] - l[i]+1];
            for (int j = 0; j <=r[i] - l[i] ; j++) {
                convert[j] = nums[j+l[i]];
            }
            res.add(checkIsArithmetic(convert));
        }
        return res;
    }

    public static Boolean checkIsArithmetic(int[] convert) {
        Arrays.sort(convert);
        int i = 1;
        while (i < convert.length - 1) {
            if (!(convert[i+1] - convert[i] == convert[1] - convert[0])){
                return false;
            }
            i++;
        }
        return true;
    }


}

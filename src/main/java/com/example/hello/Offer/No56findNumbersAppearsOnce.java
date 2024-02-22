package com.example.hello.Offer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No56findNumbersAppearsOnce {

    public static void main(String[] args) {
        int[] numbers ={1,2,3,3,2,9};
        int[] ints = FindNumsAppearOnce(numbers);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] FindNumsAppearOnce(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> cvt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cvt.containsKey(nums[i])) {
                cvt.remove(nums[i]);
            } else {
                cvt.put(nums[i], nums[i]);
            }
        }

        int i=0;
        for (Integer number:cvt.keySet()) {
            res[i] = cvt.get(number);
            i++;
        }
        Arrays.sort(res);
        return res;
    }


}

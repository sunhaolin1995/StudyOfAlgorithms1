package com.example.hello.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No57FindNumbersWithSum {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        ArrayList<Integer> integers = FindNumbersWithSum(array, sum);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();

        int left =0,right = array.length-1;
        while (left <=right){
            if (array[left] +array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            } else if (array[left] +array[right] > sum) {
                right--;
            }else {
                left++;
            }
        }
        return res;
    }

    //hashmap
    /*public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Map<Integer, Integer> cvt = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            cvt.put(array[i], array[i]);
            if (cvt.containsKey(sum - array[i])) {
                res.add(array[i]);
                res.add(sum - array[i]);
                break;
            }
        }
        return res;
    }*/

}

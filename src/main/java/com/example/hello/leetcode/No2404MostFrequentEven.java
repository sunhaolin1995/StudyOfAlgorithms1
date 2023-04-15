package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 孙浩林
 * @date: 4/13/23 10:58
 */
public class No2404MostFrequentEven {

    public static void main(String[] args) {
        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(nums));

    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> convert  =new HashMap<>();
        for (int a : nums) {
            if (a %2 ==0){
                convert.put(a,convert.getOrDefault(a,0)+1);
            }

        }
        int res=-1,ct = 0;
        for ( Map.Entry<Integer,Integer> entry: convert.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if ( (res > key && ct == value) || ct< value ){
                res = entry.getKey();
                ct = entry.getValue();
            }
        }
        return res;


    }

}

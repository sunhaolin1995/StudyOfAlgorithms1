package com.example.hello.Offer;

import java.util.Arrays;
import java.util.Comparator;

public class No45PrintMinNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 22};
        System.out.println(PrintMinNumber(numbers));
    }

    public static String PrintMinNumber(int[] numbers) {
        //如果是空数组的话
        if (numbers == null || numbers.length == 0){
            return "";
        }
        String[] nums = new String[numbers.length];
        //将数字转换为字符
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i]+"";
        }
        //按照重载排序
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numbers.length ; i++) {
            res.append(nums[i]);
        }
        return res.toString();
    }


}

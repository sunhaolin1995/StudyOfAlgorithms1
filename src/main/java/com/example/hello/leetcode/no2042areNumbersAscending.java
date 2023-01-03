package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 1/3/23 16:46
 */
public class no2042areNumbersAscending {
    public static void main(String[] args){
        String  s = "4 5 11 26";
        System.out.println(areNumbersAscending(s));
    }

    public static boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");

        List<String> numList = new ArrayList<>();



        for (int i = 0; i < strings.length ; i++) {
            numList.add(strings[i]);
        }

        for (int i = 0; i < strings.length ; i++) {
            String s1 = strings[i];

            for (int j = 0; j < s1.length(); j++) {
                if (!Character.isDigit(s1.charAt(j))){
                    numList.set(i," ");
                }
            }
        }

        List<String> numList1 = new ArrayList<>();

        for (int i = 0; i <numList.size() ; i++) {
            if (!numList.get(i).equals(" ") ){
                numList1.add(numList.get(i));
            }
        }

        for (int i = 0; i < numList1.size()-1; i++) {
            if (Integer.valueOf(numList1.get(i)) >= Integer.valueOf(numList1.get(i+1))){
                return false;
            }
        }

        return true;
    }
}

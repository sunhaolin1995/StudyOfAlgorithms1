package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 2/7/23 09:45
 */
public class No1604AlertNames {

    public static void main(String[] args) {
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"},
                keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};

        List<String> alertNames = alertNames(keyName, keyTime);

        for (int i = 0; i < alertNames.size() ; i++) {
            System.out.println(alertNames.get(i));
        }

    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String,String> key = new HashMap<>();
        

    }

}

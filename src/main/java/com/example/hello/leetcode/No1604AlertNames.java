package com.example.hello.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Map<String,List<Integer>> convertMap = new HashMap<>();

        for (int i = 0; i < keyName.length ; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            convertMap.putIfAbsent(name,new ArrayList<>());


            int timeInMinute =Integer.valueOf(time.split(":")[0])*60 + Integer.valueOf(time.split(":")[1]);
            List<Integer> integers = convertMap.get(name);
            integers.add(timeInMinute);
            convertMap.put(name,integers);
        }

        List<String> result = new ArrayList<>();
        Set<String> strings = convertMap.keySet();
        for (String key :strings) {
            List<Integer> times = convertMap.get(key);
            Collections.sort(times);
            for (int i = 2; i < times.size() ; i++) {
                if (times.get(i) - times.get(i-2)<=60 ){
                    result.add(key);
                    break;
                }
            }
        }

        Collections.sort(result);
        return result;
    }

}

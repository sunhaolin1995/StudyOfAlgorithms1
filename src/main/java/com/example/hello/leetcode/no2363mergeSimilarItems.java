package com.example.hello.leetcode;

import java.util.*;

/**
 * @author 孙浩林
 * @date: 2/28/23 17:51
 */
public class no2363mergeSimilarItems {

    public static void main(String[] args) {
        int[][] items1 = {{1,1},{4,5},{3,8}}, items2 = {{3,1},{1,5}};

        System.out.println( mergeSimilarItems(items1,items2));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], map.getOrDefault(items1[i][0],0)+items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0], map.getOrDefault(items2[i][0],0)+items2[i][1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer key:map.keySet()) {
           List<Integer> list = new ArrayList<>();
           list.add(key);
           list.add(map.get(key));
           result.add(list);
        }

        Collections.sort(result,(a,b)-> a.get(0)-b.get(0));

        return result;
    }

}

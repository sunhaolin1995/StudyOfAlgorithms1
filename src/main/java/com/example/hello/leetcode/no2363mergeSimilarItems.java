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

    /*public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

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
    }*/
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        /*int[] ans = new int[1001];
        for (int[] x : items1) {
            ans[x[0]] += x[1];
        }
        for (int[] x : items2) {
            ans[x[0]] += x[1];
        }*/

        int[] ans = new int[1001];
        for (int i = 0; i < items1.length; i++) {
           ans[items1[i][0]] += items1[i][1];
        }
        for (int j = 0; j < items2.length; j++) {
            ans[items2[j][0]] += items2[j][1];
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i]>0){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(ans[i]);
                result.add(list);
            }
        }

        return result;
    }


}

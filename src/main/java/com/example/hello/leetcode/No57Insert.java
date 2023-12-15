package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No57Insert {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            for (int j = 0; j < insert[i].length; j++) {
                System.out.println(insert[i][j]);
            }
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i=0;
        //判断左边不重合
        while ( i<len && intervals[i][1] <newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //判断重合
        while (i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        //判断右边不重合
        while (i <len && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);

    }


}

package com.example.hello.leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class No56Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4},{0, 4}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j <merge[i].length ; j++) {
                System.out.println(merge[i][j]);
            }
        }

    }

    public static int[][] merge(int[][] intervals) {
        //先排序
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        //遍历合并
        List<int[]> cvt = new ArrayList<>();

        for (int i = 0; i < intervals.length ; ) {
            //当前合并区间的结束位置
            int rightNum = intervals[i][1];
            //寻找下一个与当前区间相交的区间
            int next =i+1;
            while (next< intervals.length && rightNum >=intervals[next][0]){
                rightNum = Math.max(rightNum,intervals[next][1]);
                next++;
            }
            cvt.add(new int[]{intervals[i][0],rightNum});
            i =next;
        }

        int[][] res = new int[cvt.size()][2];
        for (int i = 0; i < cvt.size() ; i++) {
            res[i]= cvt.get(i);
        }
        return res;
    }

}

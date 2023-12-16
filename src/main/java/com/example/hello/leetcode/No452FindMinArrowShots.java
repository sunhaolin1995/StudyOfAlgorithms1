package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No452FindMinArrowShots {

    public static void main(String[] args) {
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        //对第二位开始排序
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        List<Integer> cvt = new ArrayList<>();
        for (int i = 0; i < points.length; ) {
            int arrow =points[i][1];
            int j =i+1;
            while (j < points.length && points[j][0]<= points[i][1]){
                j++;
            }
            arrow = points[i][1];
            cvt.add(arrow);
            i=j;

        }
        return cvt.size();
    }

}

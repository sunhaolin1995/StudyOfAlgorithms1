package com.example.hello.leetcode;

import java.util.PriorityQueue;

/**
 * @author 孙浩林
 * @date: 2/19/23 14:09
 */
public class no1792MaxAverageRatio {

    public static void main(String[] args) {

        int[][] classes = {{1,2},{3,5},{2,2}};

        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes,extraStudents));


    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            long val1 = (long)(b[1] + 1)*b[1]*(a[1] -a[0]);
            long val2 = (long)(a[1] + 1)*a[1]*(b[1] -b[0]);
            if (val1 == val2){
                return 0;
            }
            return val1<val2 ? 1 :-1;
        });

        for (int[] c: classes) {
            pq.offer(new int[]{c[0],c[1]});
        }

        for (int i =0;i<extraStudents ;i++){
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double res = 0;
        for (int i = 0;i< classes.length;i++){
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }

        return res/classes.length;
    }

}

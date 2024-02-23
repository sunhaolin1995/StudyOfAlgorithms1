package com.example.hello.Offer;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No59maxInWindows {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> integers = maxInWindows(num, size);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        int n = num.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < size; i++) {
            pq.offer(new int[]{num[i], i});
        }
        int[] ans = new int[n - size + 1];

        ans[0] = pq.peek()[0];
        for (int i = size; i < n; i++) {
            pq.offer(new int[]{num[i], i});
            while (pq.peek()[1] <= i - size) {
                pq.poll();
            }
            ans[i - size + 1] = pq.peek()[0];
        }

        ArrayList<Integer> res = new ArrayList<>();
        return res;
    }


    /*public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size ==0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= num.length - size; i++) {
            int maxValue = num[i];
            for (int j = 1; j < size; j++) {
                maxValue = Math.max(maxValue, num[j+i]);
            }
            res.add(maxValue);
        }
        return res;
    }*/

}

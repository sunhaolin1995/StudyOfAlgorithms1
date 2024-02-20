package com.example.hello.Offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class No49uglyNumber {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }


    public static int GetUglyNumber_Solution(int index) {
        // write code here
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < index; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }


}

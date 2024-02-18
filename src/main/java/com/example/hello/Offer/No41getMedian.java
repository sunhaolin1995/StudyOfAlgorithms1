package com.example.hello.Offer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No41getMedian {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < nums.length; i++) {
            Insert(nums[i]);
            System.out.println(GetMedian());
        }
    }

    public static Queue<Integer> minHeap = new PriorityQueue<>();

    public static Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));


    public static void Insert(Integer num) {
        if (maxHeap.isEmpty()){
            maxHeap.offer(num);
        }else {
            if (num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public static Double GetMedian() {
        if (minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }else {
            return (double)maxHeap.peek();
        }
    }


    /*public static ArrayList<Integer> cvt = new ArrayList<>();

    public static void Insert(Integer num) {
        int insert = 0;
        for (int i = 0; i < cvt.size(); i++) {
            if (cvt.get(i) <= num) {
                insert++;
            }
        }
        cvt.add(insert, num);
    }

    public static Double GetMedian() {
        if (cvt.size() % 2 == 0) {
            return (double) (cvt.get(cvt.size() / 2) + cvt.get(cvt.size() / 2 - 1)) / 2;
        } else {
            return (double) cvt.get((cvt.size() - 1) / 2);
        }
    }*/


}

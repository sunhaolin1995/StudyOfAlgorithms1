package com.example.hello.Offer;


import java.util.ArrayDeque;
import java.util.Deque;

public class No31IsPopOrder {
    public static void main(String[] args) {
        int[] pushV = {1}, popV = {2};
        System.out.println(IsPopOrder(pushV, popV));
    }

    public static boolean IsPopOrder(int[] pushV, int[] popV) {
        Deque<Integer> cvt = new ArrayDeque<>();
        cvt.push(-1001);
        int popI = 0;
        int pushI = 0;
        while (pushI < pushV.length) {
            while (cvt.peek() == popV[popI]){
                cvt.pop();
                popI++;
            }
            if (cvt.peek() != popV[popI]){
                cvt.push(pushV[pushI]);
                pushI++;
            }
        }
        while (cvt.size() >1){
            if (cvt.peek() == popV[popI]){
                popI++;
            }
            cvt.pop();
        }
        return popI == popV.length;

    }
}

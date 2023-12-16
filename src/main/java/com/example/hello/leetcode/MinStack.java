package com.example.hello.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 孙浩林
 * @date: 12/16/23 16:02
 */
class MinStack {


    private Deque<Integer> deque;

    private Deque<Integer> minDeque;



    public MinStack() {
        deque = new LinkedList<>();
        minDeque = new LinkedList<>();
        minDeque.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        deque.push(val);
        minDeque.push(Math.min(val,minDeque.peek()));
    }

    public void pop() {
       deque.pop();
       minDeque.pop();
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return minDeque.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

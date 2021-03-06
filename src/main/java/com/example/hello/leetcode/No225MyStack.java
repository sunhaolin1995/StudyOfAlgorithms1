package com.example.hello.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 孙浩林
 * @date: 2022/1/27 9:36 下午
 */
public class No225MyStack {

    private Queue<Integer> a;
    private Queue<Integer> b;

    public No225MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }
    public void push(int x) {
        a.offer(x);//将b队列中的元素全部转让给a队列
        while ( !b.isEmpty() ){
            a.offer(b.poll());

        }            //交换a和b，使得a队列没有在push()的时候始终为空队列
        Queue temp =a;
        a=b;
        b=temp;
    }
    public int pop() {
        return b.poll();
    }
    public int top() {
        return b.peek();
    }
    public boolean empty() {
        return b.isEmpty();
    }

}

package com.example.hello.Offer;

import java.util.Stack;

/**
 * @author 孙浩林
 * @date: 1/8/23 17:23
 */
public class No9CQueue {


    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public No9CQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public static void main(String[] args) {
        No9CQueue no9CQueue = new No9CQueue();
        no9CQueue.appendTail(5);
        no9CQueue.appendTail(2);
        no9CQueue.appendTail(1);

        System.out.println(no9CQueue.deleteHead());

        no9CQueue.appendTail(4);
        System.out.println(no9CQueue.deleteHead());
        System.out.println(no9CQueue.deleteHead());

        no9CQueue.appendTail(10);
        System.out.println(no9CQueue.deleteHead());
        System.out.println(no9CQueue.deleteHead());
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.empty()) {
            if (inStack.empty()) {
                return -1;
            }
        }
        while (!outStack.empty()) {
            return outStack.pop();
        }
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }


}

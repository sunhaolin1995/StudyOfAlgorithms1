package com.example.hello.Offer;

import java.util.Stack;

/**
 * @author 孙浩林
 * @date: 1/8/23 17:23
 */
public class No9CQueue {


    public static void main(String[] args) {
        No9CQueue no9CQueue= new No9CQueue();
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


    private Stack<Integer> inStack;

    private Stack<Integer> outStack;


    public No9CQueue() {
         inStack = new Stack<Integer>();
         outStack = new Stack<>();
    }

    public void appendTail(int value) {
         inStack.add(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}

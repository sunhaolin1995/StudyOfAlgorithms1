package com.example.hello.Offer;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Stack;

/**
 * @author 孙浩林
 * @date: 1/8/23 17:23
 */
public class No9CQueue {


    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

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

    public No9CQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()){
           if (inStack.isEmpty()){
               return -1;
           }
        }

        while (!outStack.isEmpty()){
            return outStack.pop();
        }

        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }


}

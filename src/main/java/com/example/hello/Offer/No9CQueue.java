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
        System.out.println(no9CQueue.deleteHead());
        System.out.println(no9CQueue.deleteHead());

    }


    private Stack<Integer> stack;

    public No9CQueue() {
         stack = new Stack<Integer>();
    }

    public void appendTail(int value) {
         stack.add(value);
    }

    public int deleteHead() {
        if (stack.size() == 0){
            return -1;
        }
        Stack<Integer> stackResult = new Stack<>();
        while (stack.size()>0){
            stackResult.add(stack.pop());
        }
        int result = stackResult.pop();

        while (stackResult.size() > 0){
            stack.add(stackResult.pop());
        }


       return result;
    }

}

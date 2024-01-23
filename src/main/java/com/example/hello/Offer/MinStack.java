package com.example.hello.Offer;


import java.util.Stack;

/***
 * 剑指offer第三十题
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());  //  返回 -3.
        minStack.pop();
        System.out.println(minStack.top());  //  返回 0.
        System.out.println(minStack.min()); //  返回 -2.
    }


    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }



    public void push(int node) {
        stack.push(node);
        minStack.push(Math.min(node, minStack.peek()));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }


}

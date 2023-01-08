package com.example.hello.Offer;


public class No30MinStack {

   private Node head;

    /** initialize your data structure here. */
    public No30MinStack() {

    }

    public void push(int x) {

        if (head == null){
            head = new Node(x,x,null);
        }else {
            head = new Node(x , Math.min(head.min, x) ,head);
        }

    }

    public void pop() {

        head = head.next;

    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }


    private class Node {

        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {

            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

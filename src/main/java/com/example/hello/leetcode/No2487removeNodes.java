package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class No2487removeNodes {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(13);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = removeNodes(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }

        /*ListNode dummy = new ListNode(-1);
        ListNode res = dummy;*/
        while(!stack.isEmpty()){
            if (head==null || stack.peek().val >= head.val){
                stack.peek().next =head;
                head =stack.peek();
            }
            stack.pop();
        }

        return head;
    }


    /*public static ListNode removeNodes(ListNode head) {
        if (head == null){
            return null;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val){
            return head.next;
        }else {
            return head;
        }

    }*/
}

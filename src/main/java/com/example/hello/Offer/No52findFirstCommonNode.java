package com.example.hello.Offer;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class No52findFirstCommonNode {

    public static void main(String[] args) {
        // 创建第一个链表的非公共部分
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        // 创建第二个链表的非公共部分
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        // 创建第一个链表和第二个链表的公共部分
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node3.next = node6;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = FindFirstCommonNode(node1, node4);
        System.out.println(listNode.val);
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            result = stack1.pop();
            stack2.pop();
        }

        return result;
    }
}

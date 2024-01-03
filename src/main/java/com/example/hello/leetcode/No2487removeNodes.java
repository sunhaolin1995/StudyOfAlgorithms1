package com.example.hello.leetcode;

public class No2487removeNodes {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
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
        if (head == null){
            return null;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val){
            return head.next;
        }else {
            return head;
        }

    }
}

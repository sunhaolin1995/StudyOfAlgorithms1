package com.example.hello.leetcode;

public class No2807InsertGreatestCommonDivisors {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(18);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(10);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = insertGreatestCommonDivisors(listNode1);
        while (listNode != null){
            System.out.println();
        }

    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        return null;
    }
}

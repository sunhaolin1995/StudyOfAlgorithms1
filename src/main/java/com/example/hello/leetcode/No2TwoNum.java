package com.example.hello.leetcode;

public class No2TwoNum {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next =listNode5;
        listNode5.next =listNode6;

        ListNode res = addTwoNumbers(listNode1, listNode4);
        while (res != null){
            System.out.println(res.val);
            res =res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null || l2 != null){
           int x =(l1 != null)? l1.val : 0;
           int y =(l2 != null)? l2.val : 0;
           int sum = x+y+carry;

           carry =sum/10;
           current.next =new ListNode(sum %10);

           if (l1 != null){
               l1 =l1.next;
           }
           if (l2 != null){
               l2 =l2.next;
           }
           current =current.next;
        }
        if (carry >0){
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}

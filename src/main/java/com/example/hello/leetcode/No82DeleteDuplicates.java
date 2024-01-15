package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 12/26/23 21:17
 */
public class No82DeleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode listNode = deleteDuplicates(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next!=null) {
            if ( cur.next.val == cur.next.next.val) {
                int num = cur.next.val;
                while (cur.next != null && cur.next.val == num) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }


    /*public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0,head);

        ListNode curr =dummy;

        while (curr.next != null && curr.next.next!=null) {
            if (curr.next.val == curr.next.next.val){
                int x =curr.next.val;
                while (curr.next != null && curr.next.val==x){
                    curr.next =curr.next.next;
                }
            }else {
                curr =curr.next;
            }

        }
        return dummy.next;
    }*/

}

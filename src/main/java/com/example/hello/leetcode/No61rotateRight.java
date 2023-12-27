package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 12/27/23 11:18
 */
public class No61rotateRight {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        /*ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);*/
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        /*listNode3.next = listNode4;
        listNode4.next = listNode5;*/

        ListNode listNode = rotateRight(listNode1, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-201);
        ListNode dummyCopy = dummy;
        ListNode pre = new ListNode(-201);
        ListNode res = pre;

        int count = 0;
        ListNode countListNode = head;
        while (countListNode != null) {
            countListNode = countListNode.next;
            count++;
        }

        int position =count - (k % count);

        while (head != null) {
            if (position > 0) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
                head = head.next;
            } else {
                pre.next = new ListNode(head.val);
                pre = pre.next;
                head = head.next;
            }
            position--;
        }
        pre.next = dummyCopy.next;
        return res.next;
    }
}

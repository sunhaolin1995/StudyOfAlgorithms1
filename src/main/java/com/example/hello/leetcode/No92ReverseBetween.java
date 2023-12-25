package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 12/25/23 21:07
 */
public class No92ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        /*ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);*/
        listNode1.next = listNode2;
       /* listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;*/
        ListNode listNode = reverseBetween(listNode1, 1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode =listNode.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftcvt1 = new ListNode();
        ListNode leftCvt = leftcvt1;
        ListNode rightCvt1 = new ListNode();
        ListNode rightCvt = rightCvt1;

        int count =1;
        List<Integer> cvt1 = new ArrayList<>();
        while (head != null) {
            if (count < left) {
                leftCvt.next = new ListNode(head.val);
                leftCvt = leftCvt.next;
            }
            if (count>= left && count<= right) {
                cvt1.add(head.val);
            }
            if (count> right) {
                rightCvt.next = new ListNode(head.val);
                rightCvt = rightCvt.next;
            }
            head = head.next;
            count++;
        }

        ListNode res = new ListNode(-1);
        ListNode res1 = res;
        while (leftcvt1.next != null) {
            leftcvt1 = leftcvt1.next;
            res.next = new ListNode(leftcvt1.val);
            res = res.next;
        }
        for (int i = cvt1.size() - 1; i >= 0; i--) {
            res.next= new ListNode(cvt1.get(i));
            res = res.next;
        }
        while (rightCvt1.next != null) {
            rightCvt1 = rightCvt1.next;
            res.next = new ListNode(rightCvt1.val);
            res = res.next;
        }
        return res1.next;
    }


}

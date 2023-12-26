package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 12/25/23 21:07
 */
public class No92ReverseBetween {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseBetween(listNode1, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;

        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummyNode.next;

    }

    /*public static ListNode reverseBetween(ListNode head, int left, int right) {

        //因为头节点可能变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        //第一步：从虚拟头节点走 left-1 步，来到 left 的前一个节点
        //建议写在 for 循环中，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //第二部：从 pre 再走 right——left+1步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right-left +1; i++) {
            rightNode =rightNode.next;
        }

        //第三步： 切断出一个子链表(截断链表)
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        //注意：切断链表
        pre.next =null;
        rightNode.next =null;

        reverseLinkedList(leftNode);

        //第五步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next =curr;
        return dummyNode.next;

    }*/


    public static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }


/*
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
    }*/


}

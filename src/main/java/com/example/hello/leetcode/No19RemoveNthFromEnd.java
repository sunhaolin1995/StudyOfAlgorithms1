package com.example.hello.leetcode;

import java.util.List;

/**
 * @author 孙浩林
 * @date: 2022/4/6 12:46 下午
 */
public class No19RemoveNthFromEnd {
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

        ListNode listNode = removeNthFromEnd(listNode1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode cvt = head;
        int count = 0;
        while (cvt != null) {
            cvt = cvt.next;
            count++;
        }
        int position =count-n;

        ListNode cvt1 =dummy;
        while (head !=null){
            if (position == 0){
                head=head.next;
            }else {
                cvt1.next =new ListNode(head.val);
                cvt1=cvt1.next;
                head=head.next;
            }
            position--;
        }
        return dummy.next;
    }

}

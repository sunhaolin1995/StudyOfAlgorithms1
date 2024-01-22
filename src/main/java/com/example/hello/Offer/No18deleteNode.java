package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/22/24 08:35
 */
public class No18deleteNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode = deleteNode(listNode1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res =dummy;
        while (dummy.next != null){
            if (dummy.next.val == val){
                dummy.next = dummy.next.next;
            }
            dummy =dummy.next;
        }
        return res.next;
    }

}

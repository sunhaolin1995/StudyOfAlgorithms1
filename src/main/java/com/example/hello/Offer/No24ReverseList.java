package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/4/23 16:38
 */
public class No24ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode numTwo = new ListNode(2);
        head.next = numTwo;
        ListNode numThree = new ListNode(3);
        numTwo.next = numThree;
        ListNode numFour = new ListNode(4);
        numThree.next = numFour;
        ListNode numFive = new ListNode(5);
        numFour.next = numFive;

        ListNode listNode = reverseList(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode= listNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head ,pre =null;
        while (cur!=null){
            ListNode temp =cur.next;
            cur.next =pre;
            pre =cur;
            cur =temp;
        }
        return pre;
    }


}

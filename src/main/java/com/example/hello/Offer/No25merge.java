package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/23/24 09:51
 */
public class No25merge {
    public static void main(String[] args) {
        // 第一个链表：1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // 第二个链表：2 -> 4 -> 6
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        ListNode merge = Merge(head1, head2);
        while (merge!=null){
            System.out.println(merge.val);
            merge =merge.next;
        }

    }

    public static ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        if (pHead1 == null){
            return pHead2;
        }
        if (pHead2 == null){
            return pHead1;
        }
        ListNode mergeHead = null;
        if (pHead1.val > pHead2.val){
            mergeHead = pHead2;
            mergeHead.next = Merge(pHead1,pHead2.next);
        }else {
            mergeHead = pHead1;
            mergeHead.next = Merge(pHead2,pHead1.next);
        }
        return mergeHead;
    }

}

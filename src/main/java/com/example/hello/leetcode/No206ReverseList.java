package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/24 10:03 下午
 */
public class No206ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return  prev;



       /* if (head ==null || head.next == null){
            return head;
        }

        ListNode dummy =reverseList(head.next);
        head.next.next=head;
        head.next=null;

      return dummy;
*/

    }
}

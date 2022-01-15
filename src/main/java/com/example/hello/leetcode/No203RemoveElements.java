package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/1/15 2:10 下午
 */
public class No203RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy =new ListNode(0);
        dummy.next=head;

        ListNode temp =dummy;

        while (temp.next !=null){
            if (temp.next.val==val){
                temp.next=temp.next.next;
            }
            else{
                temp =temp.next;
            }
        }

        return dummy.next;

        /*if ( head == null ){
            return head;
        }
        head.next=removeElements(head.next,val);
        return head.val ==val ? head.next : head;
*/
    }
}

 // Definition for singly-linked list.
  class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

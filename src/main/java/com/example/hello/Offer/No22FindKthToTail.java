package com.example.hello.Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 1/22/24 14:49
 */
public class No22FindKthToTail {

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
        ListNode listNode = FindKthToTail(listNode1, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode =listNode.next;
        }
    }

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead ==null){
            return null;
        }
        // write code here
        List<ListNode> cvt = new ArrayList<>();
        while (pHead!= null){
            cvt.add(pHead);
            pHead =pHead.next;
        }
        if (cvt.size() <k){
            return null;
        }
        ListNode dummy =new ListNode(0);
        ListNode res = dummy;
        for (int i = cvt.size()-k; i < cvt.size() ; i++) {
            dummy.next = new ListNode(cvt.get(i).val);
            dummy =dummy.next;
        }
        return res.next;
    }


}

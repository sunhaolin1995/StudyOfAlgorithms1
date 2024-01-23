package com.example.hello.Offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 1/22/24 15:53
 */
public class No23EntryNodeOfLoop {

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
        listNode5.next = listNode3; // 这里是将链表闭合成环形链表

        ListNode listNode = EntryNodeOfLoop(listNode1);
        System.out.println(listNode.val);
    }

    /*public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode res =null;
        //用 hashMap
        Map<ListNode,Integer> cvt = new HashMap<>();
        while (pHead!=null){
            if (!cvt.containsKey(pHead)){
                cvt.put(pHead, pHead.val);
            }else {
                res= pHead;
                break;
            }
            pHead =pHead.next;
        }
        return res;
    }*/

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;

    }












}

package com.example.hello.leetcode;

import java.util.PriorityQueue;

/**
 * @author 孙浩林
 * @date: 2022/9/10 11:41
 */
public class leetcode23MergeKLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length ==0){
            return null;
        }
       //虚拟头节点
        ListNode dummy =new ListNode(-1);
       ListNode p =dummy;
       //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        //将k个链表的头节点加入最小堆
        for (ListNode head : lists) {
            if (head != null){
                pq.add(head);
            }
        }
        while (!pq.isEmpty()){
            //获取最小节点，接到结果链表中去
            ListNode node = pq.poll();
            p.next =node;
            if (node.next !=null){
                pq.add(node.next);
            }
            //p指针不断前进
            p =p.next;
        }

      return dummy.next;
    }
}

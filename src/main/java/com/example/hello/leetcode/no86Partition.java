package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/9/10 10:23
 */
public class no86Partition {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        //存放小于x的链表的虚拟头节点
        ListNode dummy1 =new ListNode(-1);
        //存放大于等于x的链表的虚拟头节点
        ListNode dummy2 =new ListNode(-1);
        // p1 ,p2 指针负责生成结果链表
        ListNode p1 =dummy1,p2 =dummy2;
        ListNode p =head;
        //p负责遍历链表，类似合并两个有序链表的逻辑

        //首先将一个链表分解为两个链表
        while ( p != null){
            if (p.val >= x){
                p2.next = p;
                p2 =p2.next;
            }else {
                p1.next =p;
                p1=p1.next;
            }
            //断开原来链表的每个节点的next;
            ListNode temp =p.next;
            p.next = null;
            p = temp;
        }

     p1.next = dummy2.next;
     dummy2.next = null;

     return dummy1.next;

    }

}

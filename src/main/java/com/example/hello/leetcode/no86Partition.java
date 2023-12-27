package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/9/10 10:23
 */
public class no86Partition {
    public static void main(String[] args) {
        ListNode listnode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);

        listnode1.next =listNode2;
        listNode2.next =listNode3;
        listNode3.next =listNode4;
        listNode4.next =listNode5;
        listNode5.next =listNode6;

        ListNode listnode = partition(listnode1, 3);
        while (listnode != null){
            System.out.println(listnode.val);
            listnode=listnode.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        //result listNode
        ListNode dummy =new ListNode();

        //leftListNode
        ListNode leftListNode = dummy;
        //rightListNode
        ListNode rightListNode =new ListNode();
        ListNode copyRightListNode = rightListNode;

        while (head!=null){
            //if the value of head less than x ,add the value into leftListNode
            if (head.val <x){
                leftListNode.next=new ListNode(head.val);
                leftListNode =leftListNode.next;
            } else {
                rightListNode.next = new ListNode(head.val);
                rightListNode =rightListNode.next;
            }
            head=head.next;
        }
        //merge two linkedList into one linkedList
        leftListNode.next = copyRightListNode.next;
        return dummy.next;


    }
   /* public ListNode partition(ListNode head, int x) {
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
    }*/

}

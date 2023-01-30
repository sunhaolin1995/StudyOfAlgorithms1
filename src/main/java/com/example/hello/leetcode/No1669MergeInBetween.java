package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 1/30/23 14:02
 */
public class No1669MergeInBetween {

    public static void main(String[] args) {

        ListNode listNodeA  =new ListNode(0);
        listNodeA.next = new ListNode(1);
        listNodeA.next = new ListNode(2);
        listNodeA.next = new ListNode(3);
        listNodeA.next = new ListNode(4);
        listNodeA.next = new ListNode(5);

        ListNode listNodeB = new ListNode(100000);
        listNodeB.next = new ListNode(100001);
        listNodeB.next = new ListNode(100002);
        listNodeB.next = new ListNode(100003);


        System.out.println(mergeInBetween(listNodeA,2,3,listNodeB).val);


    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i <a -1 ; i++) {
            preA = preA.next;
        }

        ListNode aftB = preA;

        for (int i = 0; i < (b+1)-(a-1)  ; i++) {
            aftB = aftB.next;
        }

        preA.next =list2;
        while (list2.next != null){
            list2 = list2.next;
        }
        list2.next = aftB;

        return list1;

    }

}

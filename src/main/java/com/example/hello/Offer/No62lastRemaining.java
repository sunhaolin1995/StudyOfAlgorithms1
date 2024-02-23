package com.example.hello.Offer;

public class No62lastRemaining {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;

        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;

    }

   /* public int LastRemaining_Solution(int n, int m) {

        if (n <= 0 || m <= 0) {
            return -1;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;


        //k表示走的步数
        int k = 0;
        while (node.next != node) {
            if (++k == m) {
                node.next = node.next.next;
                k = 0;
            } else {
                node = node.next;
            }
        }

        return node.val;
    }*/
}

package com.example.hello.leetcode;

import java.util.*;

/**
 * @author 孙浩林
 * @date: 4/18/23 16:23
 */
public class No1019NextLargerNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode numTwo = new ListNode(2);
        head.next = numTwo;
        ListNode numThree = new ListNode(3);
        numTwo.next = numThree;
        ListNode numFour = new ListNode(4);
        numThree.next = numFour;
        ListNode numFive = new ListNode(5);
        numFour.next = numFive;
        int[] ints = nextLargerNodes(head);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] ans;

    public static final Deque<Integer> st = new ArrayDeque<>();//单调栈（节点值）

    public static int[] nextLargerNodes(ListNode head) {
        f(head,0);
        return ans;
    }

    public static void f(ListNode node,int i){
        if (node == null){
            ans = new int[i]; // i就是链表长度
            return;
        }
        f(node.next,i+1);
        while (!st.isEmpty() && st.peek() <= node.val){
            st.pop();//弹出无用数据
        }
        if (!st.isEmpty()){
            ans[i] = st.peek();//栈顶就是第i个节点的下一个更大元素
        }
        st.push(node.val);
    }

}

package com.example.hello.Offer;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author 孙浩林
 * @date: 2022/9/13 21:29
 */
public class No6ReversePrint {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode numTwo = new ListNode(3);
        head.next = numTwo;
        ListNode numThree = new ListNode(2);
        numTwo.next = numThree;

        int[] ints = reversePrint(head);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    //use stack to store the data
    public static int[] reversePrint(ListNode head) {
        Deque<Integer> cvt = new ArrayDeque<>();
        while (head != null){
            cvt.push(head.val);
            head = head.next;
        }
        int[] res =new int[cvt.size()];
        int i =0;
        while (!cvt.isEmpty()){
            res[i] = cvt.pop();
            i++;
        }
        return res;
    }


    /*public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count =0 ;
        while(node != null){
            ++count;
            node =node.next;
        }

        int[] nums =new int[count];
        node =head;

        for (int i = count - 1 ; i >= 0 ; --i) {
            nums[i] = node.val;
            node =node.next;
        }

        return nums;

    }*/

    /*public static int[] reversePrint(ListNode head) {
        Stack<Integer> reversePrint = new Stack();
        while(head != null){
            reversePrint.push(head.val);
            head = head.next;
        }
        int[] result = new int[reversePrint.size()];
        for (int i = 0; i < result.length; i++) {
            *//***
             * The only difference between peek and pop is that the peek method just returns the topmost element;
             * however, in the case of a pop method,the topmost element is returned and also that element is deleted from the stack.
             *//*
            result[i] = reversePrint.pop();

        }
        return result;
    }*/

}

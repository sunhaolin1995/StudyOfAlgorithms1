package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 孙浩林
 * @date: 12/16/23 17:53
 */
public class No150evalRPN {

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> cvt = new ArrayDeque();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Integer s = cvt.removeFirst() + cvt.removeFirst();
                cvt.addFirst(s);
            } else if (tokens[i].equals("-")) {
                Integer removeFirst2 = cvt.removeFirst();
                Integer removeFirst1 = cvt.removeFirst();
                cvt.addFirst(removeFirst1 - removeFirst2);
            } else if (tokens[i].equals("*")) {
                Integer s = cvt.removeFirst() * cvt.removeFirst();
                cvt.addFirst(s);
            } else if (tokens[i].equals("/")) {
                Integer removeFirst2 = cvt.removeFirst();
                Integer removeFirst1 = cvt.removeFirst();
                cvt.addFirst(removeFirst1 / removeFirst2);
            } else {
                cvt.addFirst(Integer.valueOf(tokens[i]));
            }
        }
        return cvt.peek();
    }

}

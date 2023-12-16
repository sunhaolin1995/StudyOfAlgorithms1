package com.example.hello.leetcode;

import java.util.Stack;

public class No20IsValid {

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> cvt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                cvt.add(c);
            } else  {
                if((c == ')' && !cvt.isEmpty() && cvt.peek() == '(')
                        ||(c == ']' && !cvt.isEmpty() && cvt.peek() == '[')
                        || (c == '}' && !cvt.isEmpty() && cvt.peek() == '{')) {
                    cvt.pop();
                }else {
                    cvt.add(c);
                }
            }
        }
        return cvt.isEmpty();

    }


}

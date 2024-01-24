package com.example.hello.Offer;


import java.util.Stack;

public class No33VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] sequence = {4, 6, 5, 9, 8};
        System.out.println(VerifySquenceOfBST(sequence));
    }


    public static boolean VerifySquenceOfBST(int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = sequence.length - 1; i >= 0; i--) {
            if (sequence[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > sequence[i]) {
                root = stack.pop();
            }
            stack.add(sequence[i]);
        }
        return true;
    }


    /*public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0){
            return true;
        }
        return recur(sequence, 0, sequence.length - 1);
    }

    public static boolean recur(int[] sequence, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (sequence[p] < sequence[j]) {
            p++;
        }
        int m = p;
        while (sequence[p] > sequence[j]) {
            p++;
        }
        return p == j && recur(sequence, i, m - 1) && recur(sequence, m, j - 1);
    }*/


}

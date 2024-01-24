package com.example.hello.Offer;


public class No33VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] sequence = {4,6,5,9,8};
        System.out.println(VerifySquenceOfBST(sequence));
    }


    public static boolean VerifySquenceOfBST(int[] sequence) {
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
    }


}

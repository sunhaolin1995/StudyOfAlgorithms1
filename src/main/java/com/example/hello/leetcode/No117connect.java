package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class No117connect {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.right.right = new Node(7);
        Node connect = connect(node1);
        soutTreeNode(connect);
    }

    public static void soutTreeNode(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        soutTreeNode(root.left);
        soutTreeNode(root.right);
        soutTreeNode(root.next);
    }



    public static Node connect(Node root) {
        if (root == null){
            return null;
        }
        Deque<Node> cvt = new LinkedList<>();
        cvt.offer(root);
        while (!cvt.isEmpty()){
            int n =cvt.size();
            Node last =null;

            for (int i = 1; i <=n ; i++) {
                Node f =cvt.poll();
                if (f.left!=null){
                    cvt.offer(f.left);
                }
                if (f.right != null){
                    cvt.offer(f.right);
                }
                if (i!=1){
                    last.next =f;
                }
                last = f;
            }

        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

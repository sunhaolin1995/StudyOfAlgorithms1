package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No230kthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        //root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while ( root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root =stack.pop();
            --k;
            if (k == 0){
                break;
            }
            root=root.right;
        }
        return root.val;

    }



}

package com.example.hello.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No101IsSymmetric {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(4);
        treeNode1.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> cvt = new LinkedList<>();
        cvt.offer(root.left);
        cvt.offer(root.right);

        while (!cvt.isEmpty()) {
            TreeNode leftNode = cvt.poll();
            TreeNode rightNode = cvt.poll();

            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            cvt.offer(leftNode.left);
            cvt.offer(rightNode.right);
            cvt.offer(leftNode.right);
            cvt.offer(rightNode.left);
        }
        return true;
    }



}

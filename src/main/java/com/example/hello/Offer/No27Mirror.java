package com.example.hello.Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 孙浩林
 * @date: 1/23/24 13:54
 */
public class No27Mirror {

    public static void main(String[] args) {
// 树：[8,6,10,5,7,9,11]
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        TreeNode mirror = Mirror(root);

        printTree(mirror);

    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode res = pRoot;
        Queue<TreeNode> cvt = new LinkedList<>();
        cvt.offer(pRoot);
        while (!cvt.isEmpty()) {
            TreeNode node = cvt.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;
            //交换左右子节点
            node.left=right;
            node.right =left;

            if (right != null) {
                cvt.offer(right);
            }
            if (left != null) {
                cvt.offer(left);
            }
        }
        return res;
    }

    /*public static TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode res = new TreeNode(pRoot.val);
        res.left = Mirror(pRoot.right);
        res.right = Mirror(pRoot.left);
        return res;
    }*/


}

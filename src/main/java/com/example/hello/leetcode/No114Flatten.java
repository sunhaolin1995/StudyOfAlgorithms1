package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class No114Flatten {

    public static void main(String[] args) {
        TreeNode treeNode1 =null;
       /* TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(5);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.right = new TreeNode(6);*/


        flatten(treeNode1);
        while (treeNode1 != null){
            System.out.println(treeNode1.val);
            treeNode1 = treeNode1.right;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null){
            return ;
        }
        TreeNode treeNode = myFlattern(root);
        root.left =null;
        root.right =treeNode.right;
    }
    public static TreeNode myFlattern(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode dummy = new TreeNode(-1);
        TreeNode res = dummy;

        Deque<TreeNode> cvt = new ArrayDeque();
        cvt.addFirst(root);
        while (!cvt.isEmpty()){
            TreeNode pop = cvt.removeFirst();
            TreeNode left = pop.left;
            TreeNode right = pop.right;
            dummy.right =new TreeNode(pop.val);
            dummy =dummy.right;
            if (right!= null){
                cvt.addFirst(right);
            }
            if (left != null){
                cvt.addFirst(left);
            }
        }
        return res.right;
    }


}

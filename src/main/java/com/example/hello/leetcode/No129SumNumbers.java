package com.example.hello.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No129SumNumbers {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(9);
        treeNode1.right =new TreeNode(0);
        treeNode1.left.left = new TreeNode(5);
        treeNode1.left.right = new TreeNode(1);
       /* TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(0);*/

        System.out.println(sumNumbers(treeNode1));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer num = numQueue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                sum = sum + num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }



    /*public static int sumNumbers(TreeNode root) {
        int res =0;
        return addNumber(root,res);
    }

    public static int addNumber(TreeNode root,int res){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return res*10+ root.val;
        }
        return addNumber(root.left, res*10 + root.val)+
                addNumber(root.right, res*10+ root.val);

    }*/

}

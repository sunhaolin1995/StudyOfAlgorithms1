package com.example.hello.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class No104MaxDepth {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        System.out.println(maxDepth(treeNode3));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans =0;

        while ( !queue.isEmpty()){
            int size = queue.size();
            while (size >0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;

    }


    /*public static int maxDepth(TreeNode root) {
    // depth first search
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }*/

}

package com.example.hello.Offer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class No32PrintFromTopToBottom {

    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(1);
        ArrayList<Integer> integers = PrintFromTopToBottom(treeNode);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> convert = new ArrayDeque<>();
        convert.offer(root);
        while (!convert.isEmpty()) {
            TreeNode node = convert.poll();
            res.add(node.val);
            if (node.left != null) {
                convert.offer(node.left);
            }
            if (node.right != null) {
                convert.offer(node.right);
            }
        }
        return res;
    }


}

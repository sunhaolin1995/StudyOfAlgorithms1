package com.example.hello.leetcode;

import java.util.*;

public class No103ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.println(lists.get(i).get(j));
            }
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> cvt = new ArrayDeque<>();
        cvt.offer(root);
        boolean positive = true;

        while (!cvt.isEmpty()) {
            int size = cvt.size();
            Deque<Integer> levelList = new LinkedList<Integer>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode treeNode = cvt.poll();
                if (positive) {
                    levelList.offerLast(treeNode.val);
                } else {
                    levelList.offerFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    cvt.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    cvt.offer(treeNode.right);
                }
            }
            res.add(new LinkedList<Integer>(levelList));
            positive =!positive;
        }
        return res;
    }

}

package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
        for (int i = 0; i <lists.size() ; i++) {
            for (int j = 0; j <lists.get(i).size() ; j++) {
                System.out.println(lists.get(i).get(j));
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> cvt = new LinkedList<>();
        if (root!=null){
            cvt.offer(root);
        }
        while (!cvt.isEmpty()) {
            List<Integer> res1 = new ArrayList<>();
            int n = cvt.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = cvt.poll();
                res1.add(poll.val);
                if (poll.left != null) {
                    cvt.offer(poll.left);
                }
                if (poll.right != null) {
                    cvt.offer(poll.right);
                }

            }
            res.add(res1);
        }
        return res;
    }


   /*static Map<Integer,List<Integer>> cvt = new HashMap<>();


    public static void dfs(TreeNode root,int level){
        if (root == null){
            return;
        }
        List<Integer> integers = cvt.getOrDefault(level, new ArrayList<Integer>());
        integers.add(root.val);
        cvt.put(level,integers);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }*/



}

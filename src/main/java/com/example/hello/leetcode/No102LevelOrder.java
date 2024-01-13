package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   static Map<Integer,List<Integer>> cvt = new HashMap<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        List<List<Integer>> res =new ArrayList<>();
        for (Integer key: cvt.keySet()){
            res.add(cvt.get(key));
        }
        return res;
    }
    public static void dfs(TreeNode root,int level){
        if (root == null){
            return;
        }
        List<Integer> integers = cvt.getOrDefault(level, new ArrayList<Integer>());
        integers.add(root.val);
        cvt.put(level,integers);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }



}

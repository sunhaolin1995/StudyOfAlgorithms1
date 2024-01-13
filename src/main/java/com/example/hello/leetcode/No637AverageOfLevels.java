package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No637AverageOfLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        /*root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        List<Double> doubles = averageOfLevels(root);
        for (int i = 0; i < doubles.size(); i++) {
            System.out.println(doubles.get(i));
        }
    }

    static Map<Integer,List<TreeNode>> counts = new HashMap<>();
    static Map<Integer,Integer> sums = new HashMap<>();

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res =new ArrayList<>();
        dfs(root,0);
        for (Integer depth:counts.keySet()){
            double cvt =0;
            List<TreeNode> treeNodes = counts.get(depth);
            for (TreeNode treeNode:treeNodes){
                cvt =cvt+treeNode.val;
            }
            Integer num = sums.get(depth);
            Double cvt1 = cvt/num;
            res.add(cvt1);
        }
        return res;
    }

    public static void dfs(TreeNode root,Integer level){
        if (root == null){
            return;
        }
        List<TreeNode> cvt = counts.getOrDefault(level, new ArrayList<TreeNode>());
        cvt.add(root);
        counts.put(level,cvt);
        Integer sum = sums.getOrDefault(level,0);
        sum++;
        sums.put(level,sum++);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}

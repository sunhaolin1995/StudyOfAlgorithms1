package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No199RightSideView {

    public static void main(String[] args) {
// 给定的二叉树表示 [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> integers = rightSideView(root);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    private static final List<Integer> ans = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

   /* public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> rightMostValueAtDepth = new HashMap<>();
        int max_depth =-1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()){
            TreeNode node =nodeStack.pop();
            Integer depth = depthStack.pop();

            if (node != null){
                //维护二叉树的最大深度
                max_depth = Math.max(max_depth,depth);
                //如果不存在对应深度的节点我们才插入
                if (!rightMostValueAtDepth.containsKey(depth)){
                    rightMostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <=max_depth ; depth++) {
            rightView.add(rightMostValueAtDepth.get(depth));
        }

        return rightView;
    }*/

}

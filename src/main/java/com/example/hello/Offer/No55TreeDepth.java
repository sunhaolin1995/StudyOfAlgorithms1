package com.example.hello.Offer;


public class No55TreeDepth {



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        System.out.println(TreeDepth(root));
    }


    public static int res = 0;
    public static int TreeDepth(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        dfs(root.left, depth + 1);
        res = Math.max(depth, res);
        dfs(root.right, depth + 1);
    }

}

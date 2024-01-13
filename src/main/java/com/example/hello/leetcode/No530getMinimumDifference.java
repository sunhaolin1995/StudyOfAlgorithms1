package com.example.hello.leetcode;

public class No530getMinimumDifference {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);
        System.out.println(getMinimumDifference(root));

    }

    static int pre;
    static int ans;

    public static int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre =-1;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root){
        if (root ==null){
            return;
        }
        dfs(root.left);
        if (pre ==-1){
            pre =root.val;
        }else {
            ans =Math.min(ans, root.val-pre);
            pre =root.val;
        }
        dfs(root.right);

    }


}

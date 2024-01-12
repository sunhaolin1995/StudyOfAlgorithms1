package com.example.hello.leetcode;

public class No236LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(1);
        treeNode1.left.left = new TreeNode(6);
        treeNode1.left.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(0);
        treeNode1.right.right = new TreeNode(8);
        treeNode1.left.right.left = new TreeNode(7);
        treeNode1.left.right.right = new TreeNode(4);
        TreeNode treeNode = lowestCommonAncestor(treeNode1, new TreeNode(5), new TreeNode(1));
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val ==p.val||root.val==q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null){
            return root;
        }else if (left!=null){
            return left;
        } else if (right!=null) {
            return right;
        }else {
            return null;
        }
    }

}

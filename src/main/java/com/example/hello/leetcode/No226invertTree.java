package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 12/28/23 16:14
 */
public class No226invertTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(7);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.right.left = new TreeNode(6);
        treeNode1.right.right = new TreeNode(9);

        TreeNode treeNode = invertTree(treeNode1);
        while (treeNode != null) {

        }

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left =right;
        root.right=left;
        invertTree(left);
        invertTree(right);
        return root;
    }

}

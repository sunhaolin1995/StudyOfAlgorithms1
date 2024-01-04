package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No106BuildTree {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);

        soutTreeNode(treeNode);
    }

    public static void soutTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        soutTreeNode(root.left);
        soutTreeNode(root.right);
    }

    private static Map<Integer, Integer> cvt;

    public static TreeNode myBuildTree(int[] inOrder, int[] postOrder, int inOrder_left, int inOrder_right, int postOrder_left, int postOrder_right) {
        if (inOrder_left > inOrder_right) {
            return null;
        }
        //后序遍历最后一个节点就是根节点
        int index_root = postOrder_right;
        //在中序遍历中找到根节点
        int inOrder_root = cvt.get(postOrder[index_root]);
        //先把根节点建立出来
        TreeNode root = new TreeNode(postOrder[index_root]);
        // 左子树的长度
        int size_left_subtree = inOrder_root - inOrder_left;
        //递归地构造左子树的，并连接到根节点
        root.left = myBuildTree(inOrder, postOrder, inOrder_left, inOrder_root - 1, postOrder_left, postOrder_left + size_left_subtree - 1);
        root.right = myBuildTree(inOrder, postOrder, inOrder_root + 1, inOrder_right, postOrder_left + size_left_subtree, postOrder_right - 1);
        return root;
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        cvt = new HashMap<>();
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            cvt.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, length - 1, 0, length - 1);
    }

}

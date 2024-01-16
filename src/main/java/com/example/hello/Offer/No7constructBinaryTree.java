package com.example.hello.Offer;

import java.util.HashMap;
import java.util.Map;

public class No7constructBinaryTree {

    public static Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        printTree(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        int rootValue = preorder[preorder_left];
        Integer rootI = indexMap.get(rootValue);
        int leftTreeLength = rootI - inorder_left;

        TreeNode root = new TreeNode(rootValue);

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left +  leftTreeLength, inorder_left, rootI - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + leftTreeLength+1, preorder_right, rootI + 1, inorder_right);
        return root;
    }

/*
    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        //前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        //递归地构造左子树，并连接到根节点
        //先序遍历中{从左边界+1开始的size_left_subtree}个元素就对应了中序遍历中{从左边界开始到根 节点定位-1}的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        //递归的构造右子树，并连接到根节点
        //先序遍历中{从左边界+1+左子树节点数目 开始到 右边界 } 的元素就对应了中序遍历中 {从根节点定位+1 到 右边界}的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;

    }*/

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }


}

package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 12/28/23 13:29
 */
public class No100IsSameTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        System.out.println(isSameTree(treeNode1, treeNode2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p!=null && q!=null) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
        } else {
            return false;
        }

    }

}

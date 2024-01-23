package com.example.hello.Offer;


public class No26HasSubTree {

    public static void main(String[] args) {

        // 第一个树：[8,8,7,9,2,null,null,null,null,4,7]
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.right.left = null;
        root1.right.right = null;
        root1.left.left.left = null;
        root1.left.left.right = null;
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        // 第二个树：[8,9,2]
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(HasSubtree(root1, root2));
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }
        boolean res = false;
        if (root1.val == root2.val) {
            res = DoesTree1HaveTree2(root1, root2);
        }
        if (!res) {
            res = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return res;
    }

    public static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return DoesTree1HaveTree2(root1.left, root2.left)
                && DoesTree1HaveTree2(root1.right, root2.right);
    }

}

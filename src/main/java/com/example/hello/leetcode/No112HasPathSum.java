package com.example.hello.leetcode;

public class No112HasPathSum {

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int targetSum = 1;
        System.out.println(hasPathSum(root, targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum, root.val);
    }

    public static boolean dfs(TreeNode root, int target, int pathSum) {
        if (root == null) {
            return false;
        }
        if (pathSum == target && root.left == null && root.right == null) {
            return true;
        }
        boolean leftFlag = false, rightFlag = false;
        if (root.left != null) {
            leftFlag = dfs(root.left, target, pathSum + root.left.val);
        }
        if (root.right != null) {
            rightFlag = dfs(root.right, target, pathSum + root.right.val);
        }
        return leftFlag || rightFlag;
    }


    /*public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum- root.val)
                || hasPathSum(root.right,targetSum- root.val);

    }*/


}

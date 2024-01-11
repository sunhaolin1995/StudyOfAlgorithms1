package com.example.hello.leetcode;

public class No124MaxPathSum {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(-10);
        treeNode1.left =new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        treeNode1.right.right = new TreeNode(7);
        System.out.println(maxPathSum(treeNode1));
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        //只有在最大贡献值大于零的时候，才会选择对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int righGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = leftGain + righGain + node.val;
        maxSum = Math.max(priceNewPath, maxSum);
        return node.val + Math.max(leftGain, righGain);

    }

}

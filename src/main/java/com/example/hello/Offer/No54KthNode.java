package com.example.hello.Offer;


public class No54KthNode {
    public static int res = -1;

    public static int time;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(7);
        treeNode1.left.left = new TreeNode(2);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(6);
        treeNode1.right.right = new TreeNode(8);
        System.out.println(KthNode(treeNode1, 3));
    }

    public static int KthNode(TreeNode proot, int k) {
        time = k;
        dfs(proot);
        return res;
    }

    public static void dfs(TreeNode proot) {
        if (proot == null) {
            return;
        }
        dfs(proot.left);
        time--;
        if (time == 0) {
            res = proot.val;
        }
        dfs(proot.right);
    }


}

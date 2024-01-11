package com.example.hello.leetcode;

public class No222countNodes {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(5);
        treeNode1.right.left = new TreeNode(6);
        System.out.println(countNodes(treeNode1));
    }


    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (rightDepth == leftDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    /*  官方题解，不懂
    public static int countNodes(TreeNode root) {
       if (root == null){
           return 0;
       }
       int level =0;
       TreeNode node = root;
       while (node.left != null){
           level++;
           node =node.left;
       }

       int low = 1<<level,high =(1<<(level+1))-1;
       while (low<high){
           int mid = (high -low+1)/2+low;
           if (exists(root,level,mid)){
               low =mid;
           }else {
               high =mid-1;
           }
       }
       return low;
    }

    public static boolean exists(TreeNode root,int level,int k){
        int bits = 1<<(level -1);
        TreeNode node =root;
        while (node != null && bits >0){
            if ((bits & k)==0){
                node =node.left;
            }else {
                node =node.right;
            }
            bits >>=1;
        }
        return node != null;
    }
*/


    /*public static int countNodes(TreeNode root) {
        calulate(root);
        return num;
    }

    static int num =0;
    public static void calulate(TreeNode root) {
        if (root == null) {
            return ;
        }
        num++;
        calulate(root.left) ;
        calulate(root.right);
    }*/

}

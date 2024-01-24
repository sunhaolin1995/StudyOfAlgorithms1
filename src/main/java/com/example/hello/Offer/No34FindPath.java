package com.example.hello.Offer;

import java.util.*;


public class No34FindPath {



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(12);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(treeNode, 22);
        for (ArrayList<Integer> integers : arrayLists) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    static LinkedList<Integer> path = new LinkedList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        DFSFindPath(root,  target);
        return res;
    }

    public static void DFSFindPath(TreeNode root,int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target =target- root.val;
        if (target == 0 && root.left==null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        DFSFindPath(root.left,target);
        DFSFindPath(root.right,target);
        path.removeLast();
    }


   /* public static void DFSFindPath(TreeNode root, ArrayList<Integer> cvt, int target) {
        if (root == null) {
            return;
        }
        int sum = 0;
        ArrayList<Integer> tempCvt = new ArrayList<>();
        tempCvt.addAll(cvt);
        tempCvt.add(root.val);
        for (Integer num : tempCvt) {
            sum = sum + num;
        }
        if (sum == target && root.left == null && root.right == null) {
            res.add(tempCvt);
        }
        DFSFindPath(root.left, tempCvt, target);
        DFSFindPath(root.right, tempCvt, target);
    }*/


}

package com.example.hello.Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 1/23/24 14:44
 */
public class No28isSymmetrical {

    public static void main(String[] args) {
        // 树：[1,2,2,3,4,4,3]
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);*/
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(isSymmetrical(root));
    }

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Deque<TreeNode> cvt = new LinkedList<>();
        cvt.offer(pRoot);
        while (!cvt.isEmpty()) {
            int n = cvt.size();
            List<TreeNode> treeNodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = cvt.poll();
                treeNodes.add(node);
                if (node.val != -1){
                    if (node.left!=null){
                        cvt.offer(node.left);
                    }else {
                        cvt.offer(new TreeNode(-1));
                    }
                    if (node.right != null){
                        cvt.offer(node.right);
                    }else {
                        cvt.offer(new TreeNode(-1));
                    }
                }
            }
            for (int i = 0; i < treeNodes.size() / 2; i++) {
                if (treeNodes.get(i).val != treeNodes.get(treeNodes.size()-1-i).val){
                    return false;
                }
            }

        }
        return true;
    }

}

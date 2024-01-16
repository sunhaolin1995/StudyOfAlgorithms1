package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/16/24 11:19
 */
public class No8getNext {


    public static void main(String[] args) {
// 创建根节点
        TreeLinkNode root = new TreeLinkNode(8);
        // 创建根节点的左子节点
        TreeLinkNode left1 = new TreeLinkNode(6);
        root.left = left1;
        left1.parent = root;
        // 创建根节点的右子节点
        TreeLinkNode right1 = new TreeLinkNode(10);
        root.right = right1;
        right1.parent = root;
        // 创建左子节点的左子节点
        TreeLinkNode left2 = new TreeLinkNode(5);
        left1.left = left2;
        left2.parent = left1;
        // 创建左子节点的右子节点
        TreeLinkNode right2 = new TreeLinkNode(7);
        left1.right = right2;
        right2.parent = left1;
        // 创建右子节点的左子节点
        TreeLinkNode left3 = new TreeLinkNode(9);
        right1.left = left3;
        left3.parent = right1;
        // 创建右子节点的右子节点
        TreeLinkNode right3 = new TreeLinkNode(11);
        right1.right = right3;
        right3.parent = right1;
        TreeLinkNode treeLinkNode = GetNext(root);
        System.out.println(treeLinkNode.val);
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }
        //  第一种情况
        if (pNode.right != null) {
            TreeLinkNode rNode = pNode.right;
            while (rNode.left != null) {
                rNode = rNode.left;
            }
            return rNode;
        } else {
            //第二种情况
            while (pNode.parent != null) {
                TreeLinkNode parentNode = pNode.parent;
                if (parentNode.left == pNode) {
                    return parentNode;
                }
                pNode = pNode.parent;
            }
        }
        return null;
    }

}

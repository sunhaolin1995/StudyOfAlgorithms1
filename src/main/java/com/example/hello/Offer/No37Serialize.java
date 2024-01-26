package com.example.hello.Offer;

import java.util.*;

/**
 * @author 孙浩林
 * @date: 1/26/24 09:45
 */
public class No37Serialize {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String serialize = Serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        soutDeserialize(deserialize);

    }

    public static void soutDeserialize(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        soutDeserialize(root.left);
        soutDeserialize(root.right);
    }

    public static String Serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public static TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }



}

package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/24/24 16:06
 */
public class No36Convert {

    public static void main(String[] args) {
        TreeNode treeNode1 =new TreeNode(10);
        treeNode1.left = new TreeNode(6);
        treeNode1.right =new TreeNode(14);
        treeNode1.left.left =new TreeNode(4);
        treeNode1.left.right =new TreeNode(8);
        treeNode1.right.left =new TreeNode(12);
        treeNode1.right.right =new TreeNode(16);
        TreeNode convert = Convert(treeNode1);
        while (convert!=null){
            System.out.println(convert.val);
            convert =convert.right;
        }
    }

    static TreeNode pre,head;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            //中序遍历，叶子为空则返回
            return null;
        }
        //首先递归到最左最小值
        Convert(pRootOfTree.left);
        //找到最小值，c初始化 head 和 pre
        if (pre == null){
            head = pRootOfTree;
            pre =pRootOfTree;
        }else {//与上一个节点建立连接，将 pre 设置为当前值
            pre.right =pRootOfTree;
            pRootOfTree.left =pre;
            pre =pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return head;
    }




    /*static TreeNode pre,head;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        dfs(pRootOfTree);
        head.left =pre;
        pre.right =head;
        return head;
    }

    public static void dfs(TreeNode cur){
        if (cur == null){
            return;
        }
        dfs(cur.left);
        if (pre!= null){
            pre.right =cur;
        }else {
            head = cur;
        }
        cur.left = pre;
        pre =cur;
        dfs(cur.right);
    }*/

}

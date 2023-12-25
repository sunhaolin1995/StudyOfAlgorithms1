package com.example.hello.leetcode;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 12/25/23 17:50
 */
public class No138CopyRandomList {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.next = null;
        node5.random = node1;
        Node node = copyRandomList(node1);
        while (node != null) {
            System.out.println(node.val);
            if (node.random !=null){
                System.out.println(node.random.val);
            }else {
                System.out.println(node.random);
            }

            node = node.next;
        }

    }

    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        //创建原节点和新节点的映射关系
        Map<Node,Node> nodeMap = new HashMap<>();

        //第一次遍历，创建新节点并建立映射关系
        Node curr =head;
        while (curr != null){
            Node newNode = new Node(curr.val);
            nodeMap.put(curr,newNode);
            curr =curr.next;
        }

        //第二次遍历，设置新节点的 next 和 random 指针
        curr =head;
        while (curr != null){
            Node newNode = nodeMap.get(curr);
            newNode.next = nodeMap.get(curr.next);
            newNode.random = nodeMap.get(curr.random);
            curr =curr.next;
        }
        //返回新链表的头结点
        return nodeMap.get(head);

    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

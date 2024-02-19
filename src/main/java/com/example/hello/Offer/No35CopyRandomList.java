package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 2/19/23 19:12
 */


public class No35CopyRandomList {


    public static void main(String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        RandomListNode randomListNode5 = new RandomListNode(5);
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;
        randomListNode4.next = randomListNode5;
        randomListNode1.random = randomListNode3;
        randomListNode2.random = randomListNode5;
        randomListNode3.random = null;
        randomListNode4.random = randomListNode2;
        randomListNode5.random = null;

        RandomListNode clone = Clone(randomListNode1);
        RandomListNode dummy = clone;
        while (clone != null) {
            System.out.println(clone.label);
            clone = clone.next;
        }
        while (dummy != null) {
            if (dummy.random != null) {
                System.out.println(dummy.random.label);
            }
            dummy = dummy.next;
        }

    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        //在每个节点后插入对应的复制节点
        while (cur != null) {
            RandomListNode copyList = new RandomListNode(cur.label);
            copyList.next = cur.next;
            cur.next = copyList;
            cur = copyList.next;
        }
        //设置复制节点的 random 指针
        cur =pHead;
        while (cur!=null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur =cur.next.next;
        }
        //分离原链表和复制链表
        cur =pHead;
        RandomListNode newHead =pHead.next;
        RandomListNode newCur =newHead;
        while (cur!=null){
            cur.next =cur.next.next;
            if (newCur.next != null){
                newCur.next = newCur.next.next;
            }
            cur =cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    /*public static RandomListNode Clone(RandomListNode pHead) {
        RandomListNode dummyPhead = pHead;

        Map<Integer, RandomListNode> cvt = new HashMap<>();
        RandomListNode res = new RandomListNode(0);
        RandomListNode dummy = res;


        while (dummyPhead != null) {
            dummy.next = new RandomListNode(dummyPhead.label);
            //将链表的值和新链表对象存进去
            cvt.put(dummyPhead.label, dummy.next);
            dummyPhead = dummyPhead.next;
            dummy = dummy.next;
        }

        RandomListNode dummyPhead1 = pHead;
        RandomListNode dummy1 = res.next;
        while (dummyPhead1 != null) {
            RandomListNode random = dummyPhead1.random;
            RandomListNode randomListNode = null;
            if (random != null) {
                randomListNode = cvt.get(random.label);

            }
            dummy1.random = randomListNode;

            dummy1 = dummy1.next;
            dummyPhead1 = dummyPhead1.next;
        }
        return res.next;
    }*/

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
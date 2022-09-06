package com.example.hello.leetcode;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
// 示例 1：

//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
// 示例 2：
//
//输入：l1 = [], l2 = []
//输出：[]
//
// 示例 3：
//
//输入：l1 = [], l2 = [0]
//输出：[0]
// 提示：
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表 👍 2660 👎 0
public class No21mergeTwoLists {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1),p=dummy;
        ListNode p1 =list1,p2=list2;

        while (p1 != null && p2!= null ){
            //比较p1和p2两个指针 ，将值稍微小点的节点接到p指针
            if (p1.val > p2.val){
                p.next = p2;
                p2=p2.next;
            }else {
                p.next = p1;
                p1 =p1.next;
            }

            p=p.next;
        }

        if (p1 != null){
            p.next=p1;
        }

        if (p2!= null){
            p.next =p2;
        }

        return dummy.next;
    }

}

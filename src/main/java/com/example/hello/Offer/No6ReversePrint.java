package com.example.hello.Offer;



/**
 * @author 孙浩林
 * @date: 2022/9/13 21:29
 */
public class No6ReversePrint {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count =0 ;
        while(node != null){
            ++count;
            node =node.next;
        }

        int[] nums =new int[count];
        node =head;

        for (int i = count - 1 ; i >= 0 ; --i) {
            nums[i] = node.val;
            node =node.next;
        }

        return nums;

    }

}

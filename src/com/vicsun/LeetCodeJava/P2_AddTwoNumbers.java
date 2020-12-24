package com.vicsun.LeetCodeJava;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {// 构造体
        val = x;
    }
}

public class P2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //dummyHead 虚拟头结点

        ListNode dummyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dummyHead;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int n1 = (p1 != null) ? p1.val : 0;
            int n2 = (p2 != null) ? p2.val : 0;
            int sum = n1 + n2 + carry;
            carry =sum/10;
            curr.next = new ListNode(sum%10);
            curr=curr.next;

            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;
        }
        if(carry >0) curr.next= new ListNode(carry);


        return dummyHead.next;
    }
}
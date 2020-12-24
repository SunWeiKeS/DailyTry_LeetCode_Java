package com.vicsun.JianZhi_Offer;



public class P24_reverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next ==null){
            return head;
        }
        ListNode node=head;
        while (node.next!=null){
            node=node.next;
        }
        ListNode key=head;
        while (key!=node){
            ListNode M=key.next;
            key.next=node.next;
            node.next=key;
            key=M;
        }
        return node;
    }
}

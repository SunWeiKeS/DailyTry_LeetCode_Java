package com.vicsun.JianZhi_Offer;




public class P22_getKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int flag = 0;
        ListNode node = head;
        ListNode temp = head;
        while (node != null) {//下一个存在

            if (flag < k) {
                flag++;
            }//当两者之间得间距达不到要求的时候则++
            else {
                temp = temp.next;
            }


            node = node.next;

        }

        return temp;
    }
}

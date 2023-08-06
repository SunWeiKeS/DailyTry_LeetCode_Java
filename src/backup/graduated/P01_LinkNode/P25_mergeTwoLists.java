package backup.graduated.P01_LinkNode;


// Definition for singly-linked list.

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class P25_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null ||l2==null)
            return l1 != null ?l1:l2;

        ListNode head= new ListNode(0),cur=head;
        while (l1 !=null &&l2 !=null){
            if(l1.val<= l2.val){
                cur.next=l1;
                l1 =l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;


        return head.next;
    }
}

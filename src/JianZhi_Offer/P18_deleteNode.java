package JianZhi_Offer;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class P18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)
            return null;
        if(head.val==val){
            head=head.next;
            return head;
        }
        ListNode flag=head;

        return null;
    }
}

package backup.graduated.P01_LinkNode;



public class P24_reverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
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

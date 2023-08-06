package backup.graduated.P01_LinkNode;

public class P18_deleteNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode1(ListNode head, int val) {
        if(head==null)
            return null;
        if(head.val==val){
            head=head.next;
            return head;
        }
        ListNode pre=head,cur=head.next;
        while (cur!=null&&cur.val!=val){
            pre=cur;
            cur=cur.next;
        }//退出条件：cur为目标值
        if (cur!=null)
            pre.next=cur.next;

        return head;
    }
    public ListNode deleteNode2(ListNode head, int val) {
        if(head==null)
            return null;
        if(head.val==val){
            head=head.next;
            return head;
        }
        ListNode flag=head;
        while (flag.next!=null&&flag.next.val!=val){
            flag=flag.next;
        }////退出条件：flag.next为目标值

        if (flag.next!=null)
            flag.next=flag.next.next;
        return head;
    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null)
            return null;
        if(head.val==val){
            head=head.next;
            return head;
        }
        ListNode flag=head;
        while (flag.next!=null){
            if(flag.next.val==val){
                flag.next=flag.next.next;
                break;
            }
            flag=flag.next;
        }
        return head;
    }

}

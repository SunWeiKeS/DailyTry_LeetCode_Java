package ByteDanceBackend.P01_LinkNode;

public class P0123_24swapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode swapPairs1(ListNode head) {
        //递归版本
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=head.next;
        head.next=swapPairs1(newHead.next);
        newHead.next=head;

        return newHead;
    }


    public ListNode swapPairs(ListNode head) {
        //非递归版本，设置一个虚头
        ListNode swapHead=new ListNode(-1,head);



        return null;
    }
}

package BackUp.graduated.P01_LinkNode;

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
        ListNode dumpHead=new ListNode(-1,head);
        //设置一个头节点
        ListNode temp=dumpHead;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;

            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;

            temp=node1;//temp是作为一个头节点
        }


        return dumpHead.next;
    }
}

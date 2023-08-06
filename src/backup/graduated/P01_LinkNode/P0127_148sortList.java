package BackUp.graduated.P01_LinkNode;

public class P0127_148sortList {
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

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode slowHead=head;
        ListNode fastHead=head;
        while (fastHead.next!=null&&fastHead.next.next!=null){//快慢指针
            slowHead=slowHead.next;
            fastHead=fastHead.next.next;
        }
        ListNode minHead=slowHead.next;
        slowHead.next=null;//指针分割

        ListNode leftHead=sortList(head);
        ListNode rightHead=sortList(minHead);
        return merge(leftHead, rightHead);

    }

    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null)
            return rightHead;
        if (rightHead == null)
            return leftHead;

        if (leftHead.val < rightHead.val) {
            leftHead.next = merge(leftHead.next, rightHead);
            return leftHead;
        } else {
            rightHead.next = merge(leftHead, rightHead.next);
            return rightHead;
        }
    }
}

package backup.graduated.P01_LinkNode;

public class P0129_92reverseBetween {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumpHead=new ListNode(-1,head);

        ListNode g=dumpHead;//交换的前一个
        ListNode p=dumpHead.next;//交换的节点

        for (int i = 0; i < m-1; i++) {
            g=g.next;//g的最终位置是交换的前一个
            p=p.next;//p为第一个，他也会成为最后一个
        }

        for (int i = m; i <n ; i++) {
            ListNode move=p.next;

            p.next=p.next.next;
            move.next=g.next;
            g.next=move;

        }


        return dumpHead.next;
    }
}

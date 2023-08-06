package BackUp.graduated.P01_LinkNode;


public class P0120_21mergeTwoLists {
    class ListNode {
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

    //迭代+递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //递归
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //迭代
        ListNode head = new ListNode(-1), point = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        point.next = l1 == null ? l2 : l1;
        return head.next;

    }
}

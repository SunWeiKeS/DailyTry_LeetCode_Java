package backup.graduated.P03_Array;

/**
 * @Author:vic
 * @Date:21-5-17
 * @Content:
 */
public class P0517_142detectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        //快慢指针找入环节点
        ListNode slow=head;
        ListNode fast=head;
        /**
         * slow 相遇 a+b
         * fast 相遇 a+n(b+c)+b
         * 2(a+b)=a+n(b+c)+b
         * a=(n-1)(b+c)+c=(n-1)圈+c
         */
        while (fast!=null){
            slow=slow.next;
            if(fast.next!=null)
                fast=fast.next.next;
            else return null;

            if(fast==slow){
                ListNode temp=head;
                while (temp!=slow){
                    temp=temp.next;
                    slow=slow.next;
                }
                return slow;
            }

        }
        return null;
    }
}

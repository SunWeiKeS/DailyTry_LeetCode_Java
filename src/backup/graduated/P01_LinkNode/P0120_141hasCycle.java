package backup.graduated.P01_LinkNode;

import java.util.HashSet;

public class P0120_141hasCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(!set.contains(head)){//没找到
                set.add(head);
                head=head.next;
            }else {//有环
                return true;
            }

        }
        //无环
        return false;
    }
}

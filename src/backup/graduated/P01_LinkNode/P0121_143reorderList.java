package BackUp.graduated.P01_LinkNode;

import java.util.ArrayList;

public class P0121_143reorderList {
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

    public void reorderList(ListNode head) {
        if(head==null)
            return;
        //因为直接操作链表有难度,把链表存入数组中，再进行获取与操作
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int left = 0;
        int right=nodes.size()-1;

        while (left<right){
            nodes.get(left).next=nodes.get(right);
            left++;

            if(left==right) break;;

            nodes.get(right).next=nodes.get(left);
            right--;
        }
        nodes.get(left).next=null;

    }
}

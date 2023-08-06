package backup.graduated.P01_LinkNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:vic
 * @Date:21-4-9
 * @Content: 合并k个数组
 */
public class P0409_23mergeKLists {
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

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );
        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);

        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();//最小堆吐出第一个
            cur.next = poll;//当前最小接到cur后面
            cur = cur.next;
            if(poll.next!=null)
                queue.add(poll.next);
        }

        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        if(lists.length==2)return mergeTwoLists(lists[0],lists[1]);

        int mid=lists.length/2;//把上述的划分为两块
        ListNode[] list1= new ListNode[mid];
        ListNode[] list2= new ListNode[lists.length-mid];

        for (int i = 0; i < list1.length; i++) {
            list1[i]=lists[i];
        }
        for (int i = mid; i < lists.length; i++) {
            list2[i-mid]=lists[i];
        }



        return mergeTwoLists(
                mergeKLists(list1),
                mergeKLists(list2));
    }

    public ListNode mergeTwoLists(ListNode node1,ListNode node2){
        if (node1==null)return node2;
        if (node2==null)return node1;

        ListNode head=null;
        if(node1.val<node2.val){
            head=node1;
            head.next=mergeTwoLists(node1.next,node2);
        }else {
            head=node2;
            head.next=mergeTwoLists(node1,node2.next);
        }
        return head;
    }
}

package BackUp.graduated.P01_LinkNode;

public class P0130_147insertionSortList {

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

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //设置哑节点指向头
        ListNode dumpHead = new ListNode(-1, head);
        ListNode lastStoredNode = head;//最后一个已经排序好的节点
        ListNode curNode = lastStoredNode.next;//当前待排序节点

        while (curNode != null) {
            if (lastStoredNode.val < curNode.val) {
                //这时候说明不需要排序
                //则自动进行下一个
                lastStoredNode = lastStoredNode.next;


            } else {
                //这时候说明当前待排序节点比最后一个要小，也就是说明了需要进行插入
                //既然要插入，则需要找出最后一个比当前节点小的节点
                //设置一个前置节点prev
                ListNode prev = dumpHead;//指向哑节点
                while (prev.next.val < curNode.val) {//当前置节点的下一个比当前的小则继续遍历
                    prev = prev.next;
                }//遍历到最后next比curNode大。此时使用头插法
                lastStoredNode.next = curNode.next;//这一步是取出来当前节点
                curNode.next = prev.next;
                prev.next = curNode;

            }
            curNode = lastStoredNode.next;//最后一步是指针重定位到当前排序完的下一个


        }

        return dumpHead.next;
    }

}

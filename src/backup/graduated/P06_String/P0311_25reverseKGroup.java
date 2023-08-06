package BackUp.graduated.P06_String;

public class P0311_25reverseKGroup {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 1 通过一个索引符号进行定位，找到前k个节点
         *
         * 2 通过翻转算法，每找到k个就进行一次反转
         */

        //首先处理特殊情况
        if (head == null || head.next == null) return head;

        ListNode endK=head;
        for (int i = 0; i < k; i++) {
            //这里要记得对剩下的不足k的情况进行处理
            if(endK==null)return head;//暂时标记
            endK=endK.next;
        }
        ListNode newLag=reverseList(head, endK);//这里反转了前k个节点 之前的头也就是head变成了尾巴，此次是新头是当初的尾巴
        head.next=reverseKGroup(endK, k);


        return newLag;
    }


    //把tail当成null
    private ListNode reverseList(ListNode head, ListNode endK) {
        if (head == null) return head;
        ListNode newLag = null;
        ListNode cur = head;
        while (cur != endK) {//tail是第k+1个
            //只要当前节点不为空
            ListNode tmp = cur.next;
            cur.next = newLag;//头插法

            newLag = cur;
            cur = tmp;

        }
        return newLag;

    }
}

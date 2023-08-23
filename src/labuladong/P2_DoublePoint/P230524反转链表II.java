package labuladong.P2_DoublePoint;

public class P230524反转链表II {

    /**
     * 92. 反转链表 II
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right-1);

        return head;
    }

    ListNode flag = null;

    public ListNode reverseN(ListNode head, int right) {
        // 考虑特色场景
        if (right == 1) {
            flag = head.next;
            return head;
        }

        ListNode reversed = reverseN(head.next, right - 1);// reversed实际上是头节点了
        head.next.next = head;
        head.next = flag;
        return reversed;
    }

    /**
     * 206. 反转链表
     * https://leetcode.cn/problems/reverse-linked-list/
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 使用迭代解决
     */
    public ListNode reverseList1(ListNode head) {
        // 考虑特色场景
        if (head == null || head.next == null) {
            return head;
        }

        // 获取后面的头
        ListNode last = reverseList1(head.next);

        // 假设递归正常，下面要干什么
        head.next.next = head;
        head.next = null;

        return last;
    }

    /**
     * 使用递归法解决该问题
     */
    public ListNode reverseList2(ListNode head) {
        // 考虑特色场景
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;// 过度节点
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }
}

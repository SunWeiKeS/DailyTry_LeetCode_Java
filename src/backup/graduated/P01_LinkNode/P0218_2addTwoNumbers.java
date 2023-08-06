package backup.graduated.P01_LinkNode;

public class P0218_2addTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum=x+y+carry;

            carry=sum/10;
            sum=sum%10;
            cur.next=new ListNode(sum);

            cur=cur.next;//指向下一个
            //下一次循环使用
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(carry==1)
            cur.next=new ListNode(1);

        return pre.next;
    }
}

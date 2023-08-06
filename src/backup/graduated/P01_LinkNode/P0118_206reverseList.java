package backup.graduated.P01_LinkNode;


public class P0118_206reverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null) return null;
        ListNode newLag=null;//指向新链表的最后一个
        ListNode cur=head;//指向当前第一个

        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next=newLag;//头插法
            newLag=cur;//指针前移
            cur=tmp;
        }

        return newLag;
    }

    //没想出来这么写，看的解析，
    public ListNode reverseList(ListNode head) {//递归解法
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null||head.next==null) return head;

        ListNode p=reverseList(head.next);//递归总是自底向上的，所以先处理后面的，p始终是指向新表头节点的
        //往上看的时候，我们假设后面的全部完成了

        //如果链表是 1->2->3->4->5，那么此时的p就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4

        head.next.next=head;//意思是p中的尾的next指向head，但是p是头所以我们这不可以直接用p，
        head.next=null;//head 尾插完后就变成了 最后一个

        return p;
    }
}

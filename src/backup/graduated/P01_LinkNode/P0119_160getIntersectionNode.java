package backup.graduated.P01_LinkNode;

import java.util.HashSet;

public class P0119_160getIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //第一种，最简单的方法，就是，把一个表存到hashset里面
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {

            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempA;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        while (lengthA!=lengthB){
            if(lengthA>lengthB){
                lengthA--;
                headA=headA.next;
            }else {
                lengthB--;
                headB=headB.next;
            }
        }//这样使得两个的长度一样

        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        return headB;

    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

}

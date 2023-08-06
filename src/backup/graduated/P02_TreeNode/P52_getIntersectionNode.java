package BackUp.graduated.P02_TreeNode;



import java.util.HashSet;



public class P52_getIntersectionNode {

    class ListNode {
        int val;
        ListNode next;
    }
    //哈希解法
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) //两个表有一个为空的时候返回null值
            return null;
        //构建hashset
        HashSet<ListNode> checked= new HashSet<>();
        while (headA !=null||headB !=null){
            if(headA!=null){
                if(! checked.contains(headA)){
                    checked.add(headA);
                    headA=headA.next;
                }else {
                    return headA;
                }
            }else {
                if(! checked.contains(headB)){
                    checked.add(headB);
                    headB=headB.next;
                }else {
                    return headB;
                }
            }
        }

        return null;
    }

    //双指针解法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // AB一起走过最长的路，当长的走完，去短的起点的时候，发现他们剩下的路一样长
        if (headA==null||headB==null)
            return null;

        ListNode pA=headA,pB=headB;

        while (pA !=pB){
            pA= pA==null?headB:pA.next;
            pB= pB==null?headA:pB.next;
        }
        return pA;
    }
}

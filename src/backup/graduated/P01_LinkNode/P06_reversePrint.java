package backup.graduated.P01_LinkNode;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 栈pop方法
 */

public class P06_reversePrint {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head !=null){
            stack.push(head.val);
            head=head.next;
        }
        int size=stack.size();
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i]=stack.pop();
        }

        return arrays;

    }

    public int[] reversePrint2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head !=null){
            list.add(head.val);
            head=head.next;
        }
        int[] arrays = new int[list.size()];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i]=list.get(list.size()-1-i);
        }

        return arrays;

    }
}

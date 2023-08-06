package BackUp.graduated.P01_LinkNode;


import java.util.ArrayList;

public class P0119_234isPalindrome {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 原本想用栈的，结果发现考虑欠佳，采用复制到数组中，并采用双指针进行判断
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode p=head;
        while (p!=null){
            list.add(p.val);
            p=p.next;
        }

        //设置双指针
        int left=0;
        int right=list.size()-1;
        while (left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

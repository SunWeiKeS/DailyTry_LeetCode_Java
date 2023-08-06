package BackUp.graduated.P02_TreeNode;

import java.util.LinkedList;
import java.util.Queue;



public class P28_isSymmetric {//判断是否是轴对称
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric1(TreeNode root) {
        //后序遍历判断？
        if (root == null)//根为空
            return true;

        return isSym(root.left,root.right);
    }
    public boolean isSym(TreeNode L, TreeNode R) {
        if(L==null&&R==null)
            return true;
        if(L==null||R==null||L.val!=R.val)
            return false;

        return isSym(L.left,R.right)&&isSym(L.right,R.left);
    }

    //非递归形式：
    public boolean isSymmetric(TreeNode root) {
        if (root == null)//根为空
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();

            if(left ==null&&right==null)//两个都不存在说明布局不对称
                continue;
            //左右存在一个为空、左右都存在但是值不等，则必定不对称
            if (left ==null||right==null||left.val!=right.val)
                return false;

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);


        }

        return true;
    }
}

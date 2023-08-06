package backup.graduated.P02_TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P0207_101isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric1(TreeNode root) {
        return isSymmetric1(root, root);

    }

    boolean isSymmetric1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;//两者存在一个，或者都存在但是值不同，则不对称

        return isSymmetric1(root1.left, root2.right) && isSymmetric1(root1.right, root2.left);
    }


    public boolean isSymmetric(TreeNode root) {
        //用栈解决同样的问题
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();//吐出第1个
            TreeNode node2 = queue.poll();//吐出第2个

            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val) {
                //其中一个不存在，或则值不等
                return false;
            }
            if (node1.val == node2.val) {
                //说明两者想等，可以继续
                queue.add(node1.left);
                queue.add(node2.right);
                queue.add(node1.right);
                queue.add(node2.left);
            }
        }
        return true;

    }
}

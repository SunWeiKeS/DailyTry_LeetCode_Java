package BackUp.graduated.P02_TreeNode;


import java.util.*;

/**
 * Definition for a binary tree node.
 *
 * 两种方法解决这个问题：
 *  1. 递归方法
 *  2. 采用层次遍历法 引入queue
 */


public class P55_maxDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth1(TreeNode root) {

        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int maxDepth(TreeNode root) {

        if (root==null) return 0;
        int res=0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int counts = queue.size();

            for (int i = 0; i < counts; i++) {
                TreeNode node = queue.poll();

                if (node.left !=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }


            res++;
        }

        return res;
    }
}

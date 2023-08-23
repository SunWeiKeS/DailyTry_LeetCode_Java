package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P230722二叉树的最大深度 {

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */
    public int maxDepth(TreeNode root) {
//        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        if (root == null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }

}























package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P230722二叉树的最小深度 {

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + minDepth(root.left);
        int right = 1 + minDepth(root.right);

        if (left == 1) {
            return right;
        }
        if (right == 1) {
            return left;
        }
        return Math.min(left, right);
    }
}























package labuladong.P1_BinaryTree;

import java.util.Arrays;

public class P230815Solution {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 给定两个整数数组 preorder 和 inorder ，
     * 其中 preorder 是二叉树的先序遍历，
     * inorder 是同一棵树的中序遍历，
     * 请构造二叉树并返回其根节点。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (length == 1) {
            return root;
        }
        for (int i = 0; i < length; i++) {
            if (preorder[0] == inorder[i]) {// 说明一共有i个节点位于左子树
                int preLeftStart = 1;
                int preLeftEnd = i;
                int inLeftStart = 0;
                int inLeftEnd = i - 1;

                int preRightStart = i + 1;
                int preRightEnd = length - 1;
                int inRightStart = i + 1;
                int inRightEnd = length - 1;

                root.left = buildTree(Arrays.copyOfRange(preorder, preLeftStart, preLeftEnd + 1),
                        Arrays.copyOfRange(inorder, inLeftStart, inLeftEnd + 1));
                root.right = buildTree(Arrays.copyOfRange(preorder, preRightStart, preRightEnd + 1),
                        Arrays.copyOfRange(inorder, inRightStart, inRightEnd + 1));
                return root;
            }
        }
        return root;
    }
}

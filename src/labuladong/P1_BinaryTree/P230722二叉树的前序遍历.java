package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P230722二叉树的前序遍历 {

    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     */
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}























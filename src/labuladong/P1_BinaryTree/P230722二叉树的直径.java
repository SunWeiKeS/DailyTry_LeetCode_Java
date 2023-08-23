package labuladong.P1_BinaryTree;

public class P230722二叉树的直径 {

    /**
     * 543. 二叉树的直径
     * 相关企业
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     */

    int length = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deepOfNode(root);
        return length;
    }

    int deepOfNode(TreeNode root) {
        // 可以以某个节点为必经之路，判断左儿子和右儿子的距离之和+1
        if (root == null) {
            return 0;
        }

        int left = deepOfNode(root.left);
        int right = deepOfNode(root.right);

        length = Math.max(length, left + right);//考虑的是节点之间的路径，而不是节点个数
        return Math.max(left, right) + 1;
    }
}























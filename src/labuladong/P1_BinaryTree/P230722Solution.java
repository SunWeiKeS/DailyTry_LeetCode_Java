package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P230722Solution {
    /**
     * 494. 目标和
     * 给你一个整数数组 nums 和一个整数 target 。
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * 等价于找到nums的一个正子集、负子集，使得总和等于target
     * 通过数学公式可以得到
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     */
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return res;
    }

    public void backTracking(int[] nums, int target, int start, int sum) {
        if (start == nums.length && sum == target) {
            res++;
            return;
        }
        if (start >= nums.length) {
            return;
        }
        backTracking(nums, target, start + 1, sum - nums[start]);
        backTracking(nums, target, start + 1, sum + nums[start]);
    }


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

    /**
     * 226. 翻转二叉树
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


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


    /**
     * 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}























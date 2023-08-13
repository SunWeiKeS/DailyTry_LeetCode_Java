package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P230813Solution {
    /**
     * 652. 寻找重复的子树
     * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
     * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
     * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
     */
    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "#";
        }
        // j将子树构造为字符串
        String str = node.val + " " + dfs(node.left) + " " + dfs(node.right);
        if (map.containsKey(str) && map.get(str) == 1) {
            res.add(node);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}

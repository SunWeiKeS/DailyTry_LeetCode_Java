package BackUp.graduated.P02_TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P34_pathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    //先序遍历
    void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null)
            return;

        list.add(new Integer(root.val));

        if (root.left == null && root.right == null) {
            //叶子节点
            if (sum == root.val)
            /**
             * 值得注意的是，记录路径时若直接执行 res.append(path) ，
             * 则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
             *
             * 正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
             */
                result.add(new ArrayList<>(list));//这个时候说明已经找到了
            //既然找到了就要把他加入后在删除
            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);

    }
}

package BackUp.graduated.P02_TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P0208_113pathSum {
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



    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(),res);

        return res;


    }

    void dfs(TreeNode root, int sum, List<Integer> list,List<List<Integer>>res) {//list即返回中的子序列
        if (root == null) return;

        list.add(new Integer(root.val));
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                //这时候 说明list加上root.val就可以返回了
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);//移除最后一个
            return;
        }

        dfs(root.left, sum - root.val, list,res);
        dfs(root.right, sum - root.val, list,res);

        list.remove(list.size() - 1);

    }
}

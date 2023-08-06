package backup.graduated.P02_TreeNode;

public class P0209_543diameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return 0;

        dfs(root);
        return res;
    }


    public int dfs(TreeNode root){

        //遍历找到
        if(root==null) return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);

        //更新res
        res=Math.max(left+right, res);


        //返回这个点的深度；
        return Math.max(right, left)+1;

    }
}

package BackUp.graduated.P02_TreeNode;

import java.util.*;

public class P0206_114flatten {
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

    public void flatten1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, queue);//这个时候list已经存储了root的所有节点
        TreeNode res = new TreeNode(-1);
        TreeNode temp=res;
        while (!queue.isEmpty()){
            temp.right=queue.peek();
            temp.left=null;
            temp=temp.right;
        }
        res=res.right;


    }
    void dfs(TreeNode node,Queue<TreeNode> list){
        if(node!=null){
            list.add(node);
            dfs(node.left, list);
            dfs(node.right, list);//先序遍历
        }

    }


    public void flatten(TreeNode root) {
        if(root==null)return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;//暂时存储右边节点
        root.right=root.left;
        root.left=null;

        while (root.right!=null) root=root.right;//移动到左边节点的最后一个

        root.right=temp;



    }
}

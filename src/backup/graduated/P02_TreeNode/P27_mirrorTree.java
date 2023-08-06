package backup.graduated.P02_TreeNode;

import java.util.Stack;



public class P27_mirrorTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode mirrorTree1(TreeNode root) {
        if (root==null) return root;

        TreeNode tmp=root.left;
        root.left=mirrorTree1(root.right);
        root.right=mirrorTree1(tmp);

        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()){

            TreeNode Node = stack.pop();
            if(Node.left != null) stack.add(Node.left);
            if(Node.right != null) stack.add(Node.right);

            TreeNode tmp=Node.left;
            Node.left=Node.right;
            Node.right=tmp;

        }

        return root;
    }

}

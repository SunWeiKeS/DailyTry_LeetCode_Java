package BackUp.graduated.P02_TreeNode;

public class P0208_110isBalanced {
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

    public boolean isBalanced(TreeNode root) {
        if (root ==null)return true;

        if(!isBalanced(root.left))  return false;
        if(!isBalanced(root.right))  return false;
        int left=getMaxDepth(root.left);
        int right=getMaxDepth(root.right);

        if(Math.abs(left-right)>1)
            return false;

        return true;
    }

    int getMaxDepth(TreeNode node){
        if(node==null) return 0;

        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right))+1;
    }
}

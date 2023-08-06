package BackUp.graduated.P02_TreeNode;



public class P55_isBalanced {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //自顶而下
    public boolean isBalanced1(TreeNode root) {

        /**
         * 不断迭代得到每一层子树的深度，然后判断是否是平衡二叉
         */
        if(root==null) return true;
        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;

        int depthleft= maxDepth(root.left);
        int depthright= maxDepth(root.right);

        if(Math.abs(depthleft-depthright)>1){
            return false;
        }
        return true;


    }
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    //自上而下
    public boolean isBalanced(TreeNode root) {

        return true;
    }
}

package backup.graduated.P02_TreeNode;



public class P68_lowestCommonAncestor2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {//递归
        if (root==null)
            return null;

        if (root.val< p.val&&root.val< q.val)//均在右子树
            return lowestCommonAncestor(root.right,p,q);
        if (root.val> p.val&&root.val> q.val)//均在左子树
            return lowestCommonAncestor(root.left,p,q);

        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {//非递归

        while(root!=null){
            if(root.val< q.val&&root.val< p.val)
                root=root.right;
            else if(root.val> q.val&&root.val> p.val)
                root=root.left;
            else
                break;
        }


        return root;
    }



}

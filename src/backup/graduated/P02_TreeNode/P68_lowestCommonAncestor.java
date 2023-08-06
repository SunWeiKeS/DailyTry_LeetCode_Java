package backup.graduated.P02_TreeNode;


public class P68_lowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 寻找二叉树的最近的公共祖先
     * 三种情况：
     * 1 pq都在左子树
     * 2 pq都在右子树
     * 3 pq一个在左子树，一个在右子树，那么当前节点即最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;//什么都没找到
        if (root == p || root == q)
            return root;//在根节点找到了p或者q

        TreeNode left = lowestCommonAncestor(root.left, p, q);//在左边找pq
        TreeNode right = lowestCommonAncestor(root.right, p, q);//在右边找pq

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;
        if (right != null)
            return right;

        return null;
    }

    //简洁写法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||root == p || root == q)
            return root;//什么都没找到

        TreeNode left = lowestCommonAncestor(root.left, p, q);//在左边找pq
        TreeNode right = lowestCommonAncestor(root.right, p, q);//在右边找pq

        if (left==null) return right;//在右子树
        if (right==null) return left;//在左子树

        return root;//分别在左右子树，则当前为最近祖节点


    }

}

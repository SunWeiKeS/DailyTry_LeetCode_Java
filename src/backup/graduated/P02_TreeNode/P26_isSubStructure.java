package BackUp.graduated.P02_TreeNode;


public class P26_isSubStructure {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null||B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;

        return A.val==B.val&&recur(A.left, B.left)&&recur(A.right, B.right);
    }
}

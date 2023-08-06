package BackUp.graduated.P02_TreeNode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P0314_68lowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;


    }


    Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
    Set<TreeNode> visited = new HashSet<TreeNode>();

    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left, root);//存储某个节点的父节点
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right, root);//存储某个节点的父节点
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root);

        while (p!=null){
            visited.add(p);
            p=parent.get(p);
        }//当p不为空则不断访问p的父节点

        while (q!=null){
            if(visited.contains(q)){
                return q;
            }
            q=parent.get(q);
        }
        return null;
    }
}

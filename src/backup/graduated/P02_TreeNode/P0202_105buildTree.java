package backup.graduated.P02_TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P0202_105buildTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }

        return helper(preorderList, inorderList);
    }

    TreeNode helper(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.size() == 0) return null;

        //preoder的第一个就是根节点
        int rootVal = preorder.remove(0);
        TreeNode root = new TreeNode(rootVal);

        //得到根节点，就可以划分左右顺序
        int valIndex = inorder.indexOf(rootVal);
        root.left = helper(preorder, inorder.subList(0, valIndex));
        root.right = helper(preorder, inorder.subList(valIndex + 1, inorder.size()));
        return root;
    }
}

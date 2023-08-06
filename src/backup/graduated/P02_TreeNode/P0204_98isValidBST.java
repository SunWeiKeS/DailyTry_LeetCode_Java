package BackUp.graduated.P02_TreeNode;

import java.util.Stack;

public class P0204_98isValidBST {
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

    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST1(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;

        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大

        return isValidBST1(root.left, minVal, root.val) && isValidBST1(root.right, root.val, maxVal);
    }
    TreeNode prev;//设置一个前置节点
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        //遍历左子树，在此过程中，prev始终是null
        if (!isValidBST2(root.left)) return false;
        if(prev!=null&&prev.val>=root.val)//当前节点应该是要比先前一个大的
            return false;
        prev=root;
        //遍历右子树
        if (!isValidBST2(root.right)) return false;
        return true;//都没问题 则是true
    }

    public boolean isValidBST(TreeNode root) {
        //非递归，利用栈结构完成
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev =null;
        while (root!=null||!stack.isEmpty()){//有节点存在或者栈非空
            while (root!=null){
                stack.push(root);
                root=root.left;
            }//左子树节点全部推入，对应了 递归的左半部分
            root=stack.pop();
            if(prev!=null&&prev.val>=root.val)
                return false;

            prev=root;

            root=root.right;
        }

        return true;
    }
}

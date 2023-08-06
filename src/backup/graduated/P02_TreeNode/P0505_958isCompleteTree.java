package backup.graduated.P02_TreeNode;

import java.util.LinkedList;

/**
 * @Author:vic
 * @Date:21-5-5
 * @Content:
 */
public class P0505_958isCompleteTree {
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

    public boolean isCompleteTree1(TreeNode root) {
        //层次遍历，如果发现有null值则return false，这个null需要后面还有非null才能返回false
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur;
        list.add(root);

        boolean flag = false;
        while (!list.isEmpty()) {
            cur = list.removeFirst();//把第一个弹出
            if (cur == null) {//遇到了空值
                flag = true;
                continue;//开始下一轮，如果下一轮！null,则会跳出循环，也说明了不是完全二叉树
            }
            if (flag == true)
                return false;
            list.add(cur.left);
            list.add(cur.right);
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {
        //层次遍历，如果发现有null值则return false，这个null需要后面还有非null才能返回false
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur;
        list.add(root);
        while ((cur = list.removeFirst()) != null){

            list.addLast(cur.left);
            list.addLast(cur.right);
        } //如果没问题，接下来应该全都是空的，而不是null xxx xxx

        while (!list.isEmpty()) {
            if (list.removeLast() != null)
                return false;
        }


        return true;
    }


}

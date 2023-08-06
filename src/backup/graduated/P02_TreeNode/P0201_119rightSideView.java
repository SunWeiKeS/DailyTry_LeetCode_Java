package backup.graduated.P02_TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P0201_119rightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> list = new LinkedList<>();//用来存储
        list.add(root);//头节点放入栈中
        while (!list.isEmpty()) {
            int size = list.size();//当前元素的个数
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pop();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);//这一步是放入下一层的元素到stack里面
                }
                temp.add(node.val);
            }
            Integer integer = temp.get(temp.size() - 1);
            res.add(integer);


        }
        return res;
    }
}

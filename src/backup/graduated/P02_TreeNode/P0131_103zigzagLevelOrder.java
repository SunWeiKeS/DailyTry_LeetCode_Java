package backup.graduated.P02_TreeNode;

import java.util.*;

public class P0131_103zigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        //设置一个容器，设置一个flag用来判断左右顺序
        List<List<Integer>> levelList = new ArrayList<>();
        int flag = 0;
        //采用层次遍历法，设置一个栈结构
        Deque<TreeNode> list = new LinkedList<TreeNode>();
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
                    list.add(node.right);//注意左右顺序
                }
                if(flag%2==0){
                    temp.add(node.val);//吐出的元素加入到list中
                }else {
                    temp.add(0,node.val);//头插法
                }


            }
            levelList.add(temp);
            flag++;
        }

        return levelList;
    }
}

package BackUp.graduated.P02_TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class P32_levelOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /**
     * 采用广度优先搜索的方式，即前序遍历，利用栈结构队列结构，前面读取后面写入
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();//存放队列
        List<List<Integer>> res = new ArrayList<>();//用于返回
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();//要添加进去的结构
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();//存放队列
        queue.add(1);
        for (int i = queue.size(); i >0 ; i--) {
            queue.add(i*2);
            System.out.println(queue.size());
            System.out.println(queue.poll());

        }


    }
}

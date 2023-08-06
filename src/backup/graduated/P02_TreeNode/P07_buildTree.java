package BackUp.graduated.P02_TreeNode;


import java.util.ArrayList;
import java.util.List;


public class P07_buildTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //遍历放在list里面
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList,inorderList);
    }
    public TreeNode helper(List<Integer> preorderList, List<Integer> inorderList){
        if(inorderList.size()==0)
            return null;
        int rootVal=preorderList.remove(0);//前序遍历的第一个值就是根节点
        TreeNode root=new TreeNode(rootVal);//创造当前根节点

        int midIn=inorderList.indexOf(rootVal);//根节点中间遍历下标
        root.left=helper(preorderList,inorderList.subList(0, midIn));//包左不包右
        root.right=helper(preorderList,inorderList.subList(midIn+1, inorderList.size()));

        return root;



   }
}

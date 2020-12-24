package com.vicsun.LeetCodeJava;

import java.util.ArrayList;

/**
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 因为是前序遍历，每层我们只需要存储一个结点即可，这个节点值有可能
 会被覆盖，如果被覆盖了说明这个节点以及他的子节点都以及遍历过了，
 所以我们不用考虑被覆盖问题
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class P1028_recoverFromPreorder {
    //从先序遍历还原二叉树
    public TreeNode recoverFromPreorder(String S) {
        String[] values = S.split("-");//一个含有空值的数组
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(Integer.valueOf(values[0])));

        int level =1;
        for (int i = 1; i <values.length ; i++) {
            if(!values[i].isEmpty()){
                TreeNode treeNode = new TreeNode(Integer.valueOf(values[i]));

                list.add(level,treeNode);//在固定位置插入，后续会被覆盖
                TreeNode parent= list.get(level-1);
                if (parent.left ==null){
                    parent.left=treeNode;
                }else {
                    parent.right=treeNode;
                }
                level=1;//回到第一层

            }else {
                level++;//当值为空，说明接下来的元素在下一层了
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        P1028_recoverFromPreorder p1028_recoverFromPreorder = new P1028_recoverFromPreorder();
        p1028_recoverFromPreorder.recoverFromPreorder("1-2--3--4-5--6--7");
    }

}

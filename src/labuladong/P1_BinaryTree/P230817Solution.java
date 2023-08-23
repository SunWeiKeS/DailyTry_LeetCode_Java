package labuladong.P1_BinaryTree;

import java.util.Arrays;

/**
 * @program: DailyTry_LeetCode_Java
 * @author: Vic.sun
 * @create: 2023-08-17 21:51
 * @description:
 **/

public class P230817Solution {
   /**
    * 106. 从中序与后序遍历序列构造二叉树
    * 给定两个整数数组 inorder 和 postorder ，
    * 其中 inorder 是二叉树的中序遍历，
    * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
    **/
   public TreeNode buildTree(int[] inorder, int[] postorder) {
      int length = inorder.length;
      if (length == 0) {
         return null;
      }
      TreeNode root = new TreeNode(postorder[length - 1]);


      for (int i = 0; i < inorder.length; i++) {

         if (postorder[length - 1] == inorder[i]) { // 说明一共有i-1个节点位于左子树
            int inLeftStart = 0;
            int inLeftEnd = i - 1;

            int postLeftStart = 0;
            int postLeftEnd = i - 1;


            int inRightStart = i + 1;
            int inRightEnd = length - 1;

            int postRightStart = i;
            int postRightEnd = length - 2;

            root.left = buildTree(Arrays.copyOfRange(inorder, inLeftStart, inLeftEnd + 1),
                Arrays.copyOfRange(postorder, postLeftStart, postLeftEnd + 1));
            root.right = buildTree(Arrays.copyOfRange(inorder, inRightStart, inRightEnd + 1),
                Arrays.copyOfRange(postorder, postRightStart, postRightEnd + 1));
            break;
         }
      }
      return root;
   }
}

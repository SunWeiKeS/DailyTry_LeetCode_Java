package BackUp.graduated.P02_TreeNode;

/**
 * @program: DailyTry
 * @description:
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author: Vic.sun
 * @create: 2021-07-24 21:03
 */


public class P0724_108sortedArrayToBST {

    class TreeNode {
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


    /**
     * @description
     * @createTime 21-7-24 22:36
     * @version v1.0
     * @author sunwei
     * @param nums
     * @return
     **/
    public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums,0,nums.length-1);
    }

    TreeNode sortedArrayToBST(int[] nums,int left,int right){

        if(left>right){
            return null;
        }

        int mid=(left+right)/2;

        TreeNode root= new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,left,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,right);

        return root;

    }
}

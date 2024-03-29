package backup.graduated.P02_TreeNode;

/**
 * @program: DailyTry
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。  高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Vic.sun
 * @create: 2021-06-20 20:54
 **/

public class P0620_108sortedArrayToBST {
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
    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0, nums.length-1);
    }

    TreeNode helper(int[]nums,int start,int end){
        if(start>end){
            return null;
        }

        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums, start, mid-1);
        root.right=helper(nums, mid+1, end);
        return root;
    }
}

package labuladong.P3_DynamicProgram;


public class P0825Solution打家劫舍III {
    public int rob(TreeNode root) {
        int[] res = robDemo(root);
        return Math.max(res[0], res[1]);

    }

    public int[] robDemo(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = robDemo(root.left);
        int[] right = robDemo(root.right);

        int selected = root.val + left[1] + right[1];
        int unselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{selected, unselected};
    }

}

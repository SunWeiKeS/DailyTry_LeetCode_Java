package labuladong.P3_DynamicProgram;

public class P0823Solution打家劫舍II {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        int temp = 0;
        for (int i = 2; i < nums.length - 1; i++) {
            temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }

        int max =dp[1];

        dp[0] = nums[1];
        dp[1] = Math.max(dp[0], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return Math.max(dp[1],max);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{200, 3, 140, 20, 10}));
    }
}

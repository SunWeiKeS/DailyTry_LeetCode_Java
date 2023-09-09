package labuladong.P3_DynamicProgram;

import java.util.Arrays;

class P0908Solution目标和 {
    public static int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) return 0;
        if ((sum + target) % 2 == 1) return 0;

        int targetX = (sum + target) / 2;
        int[][] dp = new int[nums.length][targetX + 1]; // 组成元素的表达式的个数

        for (int j = 0; j <= targetX; j++) {
            if (nums[0] == j) {
                dp[0][j] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            // 注意这边已经转化为01背包问题，所有的数字都是可选可不选，而不是对数字赋予正负符号
            dp[i][0] = (int) Math.pow(2, count);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= targetX; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][targetX];
    }
}
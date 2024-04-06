package labuladong.P3_DynamicProgram;

public class Final474P0909Solution一和零 {
    /**
     * 474. 一和零
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0; // 没有元素选的集合为0;
        for (String str : strs) {
            int countM = 0;
            int countN = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') countM++;
                else countN++;
            }
            // 倒序
            for (int i = m; i >= countM; i--) {
                for (int j = n; j >= countN; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countM][j - countN] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

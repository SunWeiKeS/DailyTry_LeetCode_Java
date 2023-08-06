package backup.graduated.P05_DynamicPlanning;

/**
 * @Author:vic
 * @Date:21-4-25
 * @Content:
 */
public class P0425_518change {
    public int change(int amount, int[] coins) {
        if (coins.length <= 0) return -1;
        int[] dp = new int[amount + 1];//dp表示凑成总金额的数目,index为总金额数目
        dp[0] = 1;



        //动态规划
        //对的
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {//总金额
                if(i-coin>=0)
                    dp[i] += dp[i - coin];
            }
        }
        /**
         * 显然不能，因为我们这里定义的子问题是，必须选择第k个硬币时，凑成金额i的方案。
         * 如果交换了，我们的子问题就变了，那就是对于金额i, 我们选择硬币的方案。
         */

        // 错的
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i-coin>=0)
                    dp[i] += dp[i - coin];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(i+" "+dp[i]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new P0425_518change().change(5, new int[]{1, 2, 5});
    }
}

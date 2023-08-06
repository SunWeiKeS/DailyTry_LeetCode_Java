package backup.graduated.P05_DynamicPlanning;

import java.util.Arrays;

/**
 * @Author:vic
 * @Date:21-4-19
 * @Content:
 */
public class P0419_322coinChange {
    /**
     * @param coins:硬币数组
     * @param amount:总金额
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0) return -1;
        int[] dp = new int[amount + 1];//memo表示凑成总金额的最小硬币数目,index为总金额数目
        dp[0] = 0;

        //动态规划

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {//说明dp[i-coins[j]]存在
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;

        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (coins.length <= 0) return -1;
        int[] dp = new int[amount + 1];//memo表示凑成总金额的最小硬币数目,index为总金额数目
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        //动态规划
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {//说明dp[i-coins[j]]存在

                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }


}
class Solution1 {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0)
            return -1;

        findWay(coins,amount, 0);

        return res==Integer.MAX_VALUE?-1:res;

    }

    public void findWay(int[] coins, int amount,int count) {
        if(amount<0)
            return;//放弃

        if(amount==0)
            res=Math.min(res, count);

        for (int i = 0; i < coins.length; i++) {
            findWay(coins, amount-coins[i],count+1);
        }
    }
}
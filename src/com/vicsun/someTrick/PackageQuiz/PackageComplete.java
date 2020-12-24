package com.vicsun.someTrick.PackageQuiz;

/**
 * @description: 3、完全背包：每类物品可以无限次装进包内
 * 每个物品可以无限选用
 * 注意：这里是2维
 * 设f[i][j]表示重量不超过j公斤,物种为前i个的最大价值 可得出状态转移方程 :
 * dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-weight[i-1]] + value[i-1]);
 * 区别：0，1背包是从大到小遍历，完全背包是从小到大遍历
 * @author: vic
 * @time: 2019/10/26 17:02
 */

public class PackageComplete {

    /**
     * 思路分析：
     * 0-1背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品）,向i-1种物品时的背包添加第i种物品；
     * 而完全背包问题是在解决的当前问题（i种物品）向i种物品时的背包添加第i种物品
     * 公式计算：f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}，
     * 注意这里当考虑放入一个物品i时，应该继续考虑还可以继续放入i
     * 因此这里是f[i][y-weight[i]]+value[i]，而不是f[i-1][y-weight[i]]+value[i]
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量数组
     * @param value  物品价值数组
     * @return
     */
    public static String completePack(int V, int N, int[] weight, int[] value) {
        //初始化动态数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {//种类增加
            for (int j = 1; j < V + 1; j++) {//容量递增
                //如果第i件物品的重量大于背包容量j,则不装入
                //由于weight和value数组下标都是从0开始，故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else//dp[i][j - weight[i - 1]] + value[i - 1]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);


            }

        }
        //则容量为V的背包能装入物品的最大值为
        int maxValue = dp[N][V];
        int j = V;
        String numStr = "";
        for (int i = N; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        return numStr;

    }

    public static int completePack2(int V, int N, int[] weight, int[] value) {
        /**
         * 完全背包的第二种解法
         * 思路：
         * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
         * 用顺序来实现
         */
        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {//种类
            //顺序实现
            for (int j = weight[i - 1]; j < V + 1; j++) {//容量
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[V];
    }
}













package someTrick.PackageQuiz背包问题;

/**
 * @description: 2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
 * 每个物品都有了一定的数量
 * 设f[j]表示重量不超过j公斤的最大价值 可得出状态转移方程 ： 
 * f[j]=max{f[j],f[j−k∗w[i]]+k∗v[i]}
 * 二维的是：
 * dp[i][j]=Math.max( dp[i-1][j] , dp[i-1] [j-k*weight[i-1]] + k*value[i-1]);
 * @author: vic
 * @time: 2019/10/26 16:58
 */

public class PackageMany {
    /**
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量数组
     * @param value  物品价值数组
     * @param num    物品数量数组
     * @return
     */
    public static int manyPack(int V, int N, int[] weight, int[] value, int[] num) {
        //初始化动态数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解，将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {//物品遍历
            for (int j = 1; j < V + 1; j++) {//容量增加
                //如果第i件物品的重量大于背包容量j，则不装入背包
                //由于weight和value数组下标都是从0开始，故第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    //考虑物品的件数限制 num是每一个物品对应的最大数目，j/weight[i-1]容量与物品重量之比--最多这个物品能放几个
                    int maxV = Math.min(num[i - 1], j / weight[i - 1]);
                    for (int k = 0; k < maxV + 1; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + value[i - 1]);
                    }
                }

            }

        }
        //则容量为V的背包能装入的物品的最大值为
        int maxValue = dp[N][V];
//        int j = V;
//        String numStr = "";
//        for (int i = N; i > 0  ; i--) {
//            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
//            while (dp[i][j]>dp[i-1][j]){
//                numStr =i+" "+numStr;
//                j=j-weight[i-1];
//            }
//            if(j==0)
//                break;
//        }
        return maxValue;
    }
}

































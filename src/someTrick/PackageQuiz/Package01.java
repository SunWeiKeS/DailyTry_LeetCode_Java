package someTrick.PackageQuiz;

/**
 * @description: 一个背包的总容量为V, 现在有N类物品, 第i类物品的重量为weight[i], 价值为value[i]
 * 那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
 * ---------------------------------------------------------------------------------------------------
 * 1、0-1背包：每类物品最多只能装一次
 * 0-1背包
 * 思路分析：
 * 0-1背包问题主要涉及到两个问题的求解
 *
 * a)求解背包所含物品的最大值：
 * 利用动态规划求最优值的方法。假设用dp[N][V]来存储中间状态值,dp[i][j]表示前i件物品能装入容量为j的背包中的物品价值总和的最大值(注意是最大值),
 * 则我们最终只需求知dp[i=N][j=V]的值，即为题目所求。
 * 现在考虑动态规划数组dp[i][j]的状态转移方程：
 * 假设我们已经求出前i-1件物品装入容量j的背包的价值总和最大值为dp[i-1][j],固定容量j的值不变，则对第i件物品的装法讨论如下：
 * 首先第i件物品的重量weight[i]必须小于等于容量j才行，即
 * 1、若weight[i]>j,则第i件物品肯定不能装入容量为j的背包，此时dp[i][j]=dp[i-1][j]
 * 2、若weight[i]<=j,则首先明确的是这件物品是可以装入容量为j的背包的，那么如果我们将该物品装入，则有
 * dp[i][j]=dp[i-1][j-weight[i]]+value[i]
 * 随之而来的问题是我们要判断第i件物品装到容量为j的背包后,背包内的总价值是否是最大？其实很好判断，
 * 即如果装了第i件物品后的总价值dp[i-1][j-weight[i]]+value[i]>没装之前的总价值最大值dp[i-1][j]，则肯是最大的；
 * 反之则说明第i件物品不必装入容量为j的背包(装了之后总价值反而变小，那么肯定就不需要装嘛)
 * 故，状态转移方程如下：
 * dp[i][j] = (dp[i-1][j] > (dp[i-1][j-weight[i]]+value[i]))? dp[i-1][j]:(dp[i-1][j-weight[i]]+value[i])
 * 注意：这里的前i件物品是给定次序的
 *
 * b)求出背包中装入物品的编号
 * 这里我们采用逆推的思路来处理，如果对于dp[i][j]>dp[i-1][j]，则说明第i个物品肯定被放入了背包，此时我们再考察dp[i-1][j-weight[i]]的编号就可以了。
 * 这里dp[i][j] 对应的是数组下标i-1 中物品，i最高为n，对应数组下标n-1
 * ---------------------------------------------------------------------------------------------------
 * @author: vic
 * @time: 2019/10/26 16:58
 */


public class Package01 {
    /**
     * 0-1背包问题
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public static String ZeroOnePack(int V, int N, int[] weight, int[] value) {

        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {//容量
            for (int j = 1; j < V + 1; j++) {//种类
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        //逆推找出装入背包的所有商品的编号
        int j = V;
        String numStr = "";
        for (int i = N; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        return numStr;
    }

    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     *
     */
    public static int ZeroOnePack2(int V, int N, int[] weight, int[] value) {
        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {//种类
            //逆序实现
            for (int j = V; j >= weight[i - 1]; j--) {//容量
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

}





















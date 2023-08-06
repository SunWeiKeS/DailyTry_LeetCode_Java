package backup.graduated.P03_Array;

public class P0222_122maxProfit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int length=prices.length;
        int [][]dp= new int[length][2];
        dp[0][0]=0;//未持有股票
        dp[0][1]=-prices[0];//持有股票
        for (int i = 1; i < length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }

        return dp[length-1][0];
    }
}

package backup.graduated.P03_Array;

import java.util.Stack;

public class P0213_121maxProfit {
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int size = prices.length;
        int[][] dp = new int[size][2];
        dp[0][0] = 0;//未持有股票的收益
        dp[0][1] = -prices[0];//持有股票的收益

        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);//越接近一，越会被留下
        }

        return dp[size - 1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int size = prices.length;

        int noHold = 0;//未持有股票的收益
        int Hold = -prices[0];//持有股票的收益

        for (int i = 1; i < size; i++) {
            noHold = Math.max(noHold, Hold + prices[i]);
            Hold = Math.max(Hold, -prices[i]);
        }

        return noHold;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int size = prices.length;

        int profit = 0;//未持有股票的收益
        int minInput = prices[0];//持有股票的收益
        for (int i = 1; i < size; i++) {
            minInput = Math.min(prices[i], minInput);
            profit = Math.max(profit, prices[i] - minInput);
        }

        return profit;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        int max=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < stack.peek()) {//price比当前的小
                stack.pop();
                stack.push(prices[i]);
            }else {
                //price 比当前的大
                max=Math.max(max, prices[i]-stack.peek());
            }

        }

        return max;
    }
}

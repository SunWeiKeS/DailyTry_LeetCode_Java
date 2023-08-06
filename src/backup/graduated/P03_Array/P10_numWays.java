package BackUp.graduated.P03_Array;

public class P10_numWays {

    //递归
    public int numWays(int n) {
        if(n<=1)//只有一个台阶
            return 1;
        else if(n==2)//两个台阶
            return 2;

        return (numWays(n-1)+numWays(n-2)) %1000000007;
    }

    //动态规划
    public int numWays2(int n) {
        if (n<=1) return 1;
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]=dp[i]%1000000007; //大数越界： 随着 nn 增大, f(n)f(n) 会超过 Int32 甚至 Int64 的取值范围，导致最终的返回值错误。
        }

        return dp[n];
    }

}

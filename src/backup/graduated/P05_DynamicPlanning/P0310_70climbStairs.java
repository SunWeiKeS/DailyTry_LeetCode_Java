package backup.graduated.P05_DynamicPlanning;

public class P0310_70climbStairs {
    public int climbStairs1(int n) {
        int []arr= new int [n+1];//构造一个数组

        arr[0]=1;
        arr[1]=1;


        for (int i = 2; i <= n; i++) {

            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public int climbStairs(int n) {
        if(n==0)return 1;
        if(n==1)return 1;

        return climbStairs(n-1)+climbStairs(n-2);
    }
}

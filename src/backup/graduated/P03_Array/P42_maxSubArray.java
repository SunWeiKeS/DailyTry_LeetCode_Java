package BackUp.graduated.P03_Array;

public class P42_maxSubArray {
    public int maxSubArray1(int[] nums) {
        /**
         * 求所有子数组的和的最大值，动态规划思想
         * 基本思想：变成子问题,求以当前i为结尾的最大值
         *      实际上可以用一个数组表示每一个结尾的最大值，但是也可以仅用一个int值表示
         *  这里直接在num上操作原数组得到dp动态规划数组，节省空间---状态压缩
         */
        int res= nums[0];//初始的时候，res为第一个
        for (int i = 1; i < nums.length; i++) {
            //判断前一个的正负，用于当前的num[i],对应了动态转移方程
            nums[i]=nums[i]+Math.max(0,nums[i-1]);

            res=Math.max(res,nums[i]);
        }

        return res;
    }

    //一般的动态规划写法
    public int maxSubArray(int[] nums) {
        int[]dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

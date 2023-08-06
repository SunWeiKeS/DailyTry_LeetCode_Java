package BackUp.graduated.P03_Array;

import java.util.Arrays;

public class P0225_300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        //找最长递增的子序列长度，使用动态规划解决问题
        if(nums==null)return 0;
        if(nums.length==1) return 1;
        int dp[]= new int[nums.length];
        Arrays.fill(dp,1);

        int res=-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {//j在i元素前面
                //这里的遍历是，外围添加一个元素后，里面的就要相应的调整一次
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);//以i结尾的最长序列的长度

                }
            }
            res=Math.max(res,dp[i]);
        }


        return res;
    }


}

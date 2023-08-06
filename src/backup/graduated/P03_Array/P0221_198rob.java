package BackUp.graduated.P03_Array;

public class P0221_198rob {
    public int rob1(int[] nums) {
        //动态规划可以使用数组，也可以不使用数组
        //我们首先使用含有数组的版本
        if (nums.length == 0||nums==null)
            return 0;

        if(nums.length==1)
            return nums[0];
        int res[] = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            res[i]=Math.max(res[i-1],res[i-2]+nums[i]);

        }
        return res[nums.length-1];
    }
    public int rob(int[] nums) {
        if (nums.length == 0||nums==null)
            return 0;

        if(nums.length==1)
            return nums[0];

        int pre=0;
        int cur=0;

        for (int num : nums) {
            int temp=cur;
            cur=Math.max(cur,pre+num);
            pre=temp;
        }
        return cur;
    }
}

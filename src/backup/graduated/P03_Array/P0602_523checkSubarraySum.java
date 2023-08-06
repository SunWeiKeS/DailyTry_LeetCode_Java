package BackUp.graduated.P03_Array;

/**
 * @Author:vic
 * @Date:21-6-2
 * @Content:
 */
public class P0602_523checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1 || nums == null) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i+ 1]  == 0)
                return true;
        }

        for (int i = 0; i < nums.length-1; i++) {
            int sum=nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                sum+=nums[j];
                if(sum%k==0)
                    return true;
            }
            if(sum<k)
                break;
        }

        return false;
    }
}

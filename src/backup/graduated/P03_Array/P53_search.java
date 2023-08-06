package backup.graduated.P03_Array;

public class P53_search {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] ==target) {
                targetRange[0] = i;
                break;
            }
        }
        if (targetRange[0]==-1)
            return targetRange;

        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i] ==target) {
                targetRange[1] = i;
                break;
            }
        }

        return targetRange;
    }

    public int search(int[] nums, int target) {
        int res=0;
        for (int num:nums) {
            if (num==target){
                res++;
            }
        }

        return res;
    }
}

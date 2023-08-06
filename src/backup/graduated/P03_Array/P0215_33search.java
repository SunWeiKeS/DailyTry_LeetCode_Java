package BackUp.graduated.P03_Array;

public class P0215_33search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start]<=nums[mid]){
                //说明左半部分是有序的
                if(target>=nums[start]&&target<nums[mid]){
                    //这时候说明目标index在左边
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else {
                //说明右半部分是有序的
                if(target>nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }


        }

        return -1;
    }

}

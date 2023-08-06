package BackUp.graduated.P03_Array;

public class P0303_162findPeakElement {
    public int findPeakElement1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[nums.length - 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    public int findPeakElement(int[] nums) {
        return find(nums,0,nums.length-1);
    }

    public int find(int[]nums,int l,int r){
        if(l==r)
            return l;
        int mid=(l+r)/2;
        if(nums[mid]>nums[mid+1]){
            return find(nums,l,mid);
        }
        return find(nums,mid,r);
    }

}

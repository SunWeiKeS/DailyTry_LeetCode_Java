package leetcode_challenge;

import java.util.Arrays;

public class _561ArrayPartition {
	public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
        	System.out.println(nums[i]);
            result += nums[i];
        }
        return result;
    }
	public static void main(String[] args) {
		int []demo ={1,2,3,4,5,6,7,8,9,10};
		System.out.println(arrayPairSum(demo));
	}
}

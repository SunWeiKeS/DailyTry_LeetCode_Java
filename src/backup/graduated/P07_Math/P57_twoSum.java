package BackUp.graduated.P07_Math;

import java.util.HashSet;
import java.util.Set;

public class P57_twoSum {

    //双指针法
    public int[] twoSum1(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }else if(nums[left]+nums[right]<target){
                left++;
            }else {
                right--;
            }
        }


        return null;
    }

    //set方法
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target-num)){
                return new int[]{num,target-num};
            }else
                set.add(num);
        }


        return null;
    }

}

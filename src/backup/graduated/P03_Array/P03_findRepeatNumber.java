package BackUp.graduated.P03_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 三种不同的方法
 */
public class P03_findRepeatNumber {
    public int findRepeatNumber(int []nums){
        Arrays.sort(nums);//先排序再比较

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
        
    }


    public int findRepeatNumber2(int []nums){
        //边存哈希边比较
        Set<Integer> set = new HashSet<Integer>();
        int ans =-1;
        for (int num:nums) {
            if(!set.add(num)){
                ans =num;
                break;
            }
        }
        return ans;
    }
}

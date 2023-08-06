package backup.graduated.P03_Array;

import java.util.HashMap;

/**
 * @Author:vic
 * @Date:21-4-22
 * @Content:
 */
public class P0422_560subarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0, 1);//初始化默认值
        int count=0;//记录总数
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];//前缀的值
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);

        }

        return count;
    }
}

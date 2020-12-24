package com.vicsun.LeetCodeJava;

import java.util.HashMap;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class P1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (map.get(dif) != null) {
                res[0] = i;
                res[1] = map.get(dif);
                return res;
            }
            map.put(nums[i], i); //精妙之处在于构造map时候，将nums的键值对调。
        }
        return res;
    }
}

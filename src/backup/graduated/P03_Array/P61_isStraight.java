package BackUp.graduated.P03_Array;

import java.util.Arrays;
import java.util.HashSet;

public class P61_isStraight {
    public boolean isStraight1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0, min = 14;//为了跳过0
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (set.contains(num)) return false;

            set.add(num);
        }

        return max - min < 5;
    }

    public boolean isStraight(int[] nums) {
        int flag = 0;
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) flag++;//第一个非0
            else if (nums[i] == nums[i + 1]) return false;//两个相等

        }
        return nums[4] - nums[flag] < 5;
    }
}

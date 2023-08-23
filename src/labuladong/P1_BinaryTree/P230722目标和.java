package labuladong.P1_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class P230722目标和 {
    /**
     * 494. 目标和
     * 给你一个整数数组 nums 和一个整数 target 。
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * 等价于找到nums的一个正子集、负子集，使得总和等于target
     * 通过数学公式可以得到
     * sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     * 2 * sum(P) = target + sum(nums)
     */
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return res;
    }

    public void backTracking(int[] nums, int target, int start, int sum) {
        if (start == nums.length && sum == target) {
            res++;
            return;
        }
        if (start >= nums.length) {
            return;
        }
        backTracking(nums, target, start + 1, sum - nums[start]);
        backTracking(nums, target, start + 1, sum + nums[start]);
    }
}























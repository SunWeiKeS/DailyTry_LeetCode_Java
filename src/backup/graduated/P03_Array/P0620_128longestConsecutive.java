package backup.graduated.P03_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:vic
 * @Date:21-6-20
 * @Content:
 */
public class P0620_128longestConsecutive {
    /**
     * @description: 设定一个flag用来记录历史最长的
     * 不断遍历set
     * 找到最左边的节点，然后看它右边存不存在，存在就记录增加序列长度，如果不存在，则与flag比较
     * @param nums
     * @return
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int longest = 0;
        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                //这时候说明是最左边一个
                int localLongest = 1;
                int numLocal = num;

                while (numsSet.contains(numLocal + 1)) {
                    //说明下一个存在
                    localLongest += 1;
                    numLocal = numLocal + 1;

                }
                longest = Math.max(localLongest, longest);


            }
        }
        return longest;
    }
}

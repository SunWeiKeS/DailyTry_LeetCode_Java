package BackUp.graduated.P03_Array;

import java.util.HashMap;

public class P56_singleNumber {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
     * 请找出那个只出现一次的数字。
     *
     * 1 转换二进制进行解
     *
     * 2 利用map进行求解
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int count=hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++count);
        }
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer)==1)
                return integer;
        }

        return -1;
    }
}

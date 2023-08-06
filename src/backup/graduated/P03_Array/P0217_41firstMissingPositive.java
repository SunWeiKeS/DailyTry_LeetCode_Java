package BackUp.graduated.P03_Array;

import java.util.HashSet;

public class P0217_41firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length=nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        for (int i = 0; i < length; i++) {
            if(!set.contains(i+1)){
                return i+1;
            }
        }


        return length+1;
    }
}

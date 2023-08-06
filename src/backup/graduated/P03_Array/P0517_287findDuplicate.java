package backup.graduated.P03_Array;

/**
 * @Author:vic
 * @Date:21-5-17
 * @Content:
 */
public class P0517_287findDuplicate {
    public int findDuplicate(int[] nums) {
        //把位置上的放到该放的位置
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        P0517_287findDuplicate duplicate = new P0517_287findDuplicate();
        //duplicate.findDuplicate(new int[]{1,3,4,2,2});
        duplicate.findDuplicate(new int[]{3, 1, 3, 4, 2});

    }
}

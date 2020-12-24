package com.vicsun.LeetCodeJava;

public class P283_moveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //一次遍历，利用快排思想
        int flag=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                //找到不是0的，就和前面的flag交换
                int temp=nums[i];
                nums[i]=0;
                nums[flag++]=temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                //找到不是0的。
                nums[j++]=nums[i];
            }
        }
        for (int i = j; i <nums.length ; i++) {
            nums[i]=0;
        }
    }
}

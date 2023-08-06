package BackUp.graduated.P03_Array;

public class P21_exchange {
    public int[] exchange0(int[] nums) {
        //用快速排序进行交换，使得奇数在前面，偶数在后面
        int left=0,right=nums.length-1;//指针
        while (left<right){
            while (left<right&&nums[left]%2!=0){
                //左边碰到偶数停下来
                left++;
            }
            while (left<right&&nums[right]%2==0){
                //右边碰到奇数停下来
                right--;
            }
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
        }
        return nums;

    }

    public int[] exchange(int[] nums) {
        int flag=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2!=0){
                //碰到奇数停下来
                int tmp=nums[i];
                nums[i]=nums[flag];
                nums[flag++]=tmp;//奇数和当前i的位置进行互换
            }
        }

        return nums;

    }
}

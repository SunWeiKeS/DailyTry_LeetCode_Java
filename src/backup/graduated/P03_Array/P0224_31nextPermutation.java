package backup.graduated.P03_Array;

public class P0224_31nextPermutation {
    public static void main(String[] args) {
        P0224_31nextPermutation demo = new P0224_31nextPermutation();


    }
    public void nextPermutation(int[] nums) {
        //处理特殊情况
        if (nums == null || nums.length == 0) return;

        //从右往左找到第一个升序排列的数 12764871 即4如果不存在，这说明全是降序，那就反转数组
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;//找到第一个比右边的数小的数字。即我们要找的小数,如果左边大于右边就--
        }
        //如果这时候发现i=-1;说明没找到，说明数组从左向右是递增的，这时候就需要反转数组
        if(i==-1){
            reverse(nums,0);
        }
        //再次从右向左找到第一个比上述大的数，第一个则是最小的大数
        if(i>=0){
            int j=nums.length-1;
            while (j>=0&&nums[j]<=nums[i]){
                j--;//找到第一个比小数大的元素
            }
            //在此，我们已经找到了i,j分别是小数，大数，
            swap(nums,i,j);//交换完了之后，现在i左边的都要比i上的元素大，而且顺序是递减的
            reverse(nums,i+1);
        }

        //互换两者，将 最后右边的都升序排列

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int start){
        //开始位置向后全部反转
        int end =nums.length-1;
        while (start<end){
            swap(nums,start++,end--);
        }
    }
}

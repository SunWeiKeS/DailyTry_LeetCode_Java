package BackUp.graduated.P03_Array;

public class P59_maxSlidingWindow {


    //1 暴力求解
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums==null||k<=0||nums.length<k){
            return new int[0];
        }//去除糟糕的情况

        int length=nums.length-k+1;
        int[]result=new int[length];//创建存储最大值的空数组
        int curMax;

        for (int i = 0; i < length; i++) {
            curMax=Integer.MIN_VALUE;//设置java内置最小值
            for (int j = 0; j < k; j++) {
                curMax=Math.max(nums[i+j],curMax);//当前遍历的值和curMax对比，范围i~i+j-1

            }
            result[i]=curMax;
        }

        return result;
    }

    //最大值在滑动窗口内，就比较是否大，如果不在了，就继续寻找最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0||nums.length<k){
            return new int[0];
        }//去除糟糕的情况
        int[]result=new int[nums.length-k+1];//创建存储最大值的空数组
        int maxIndex=-1,maxValue=Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - k + 1; i++) {
            //判断最大值的下标是否在滑动窗口内
            if(maxIndex>=i){
                //此时下标在滑动窗口内，则需要比较后面的值是否大于上一个窗口
                if(nums[i+k-1]>maxValue){
                    maxValue=nums[i+k-1];
                    maxIndex=i+k-1;
                }
            }else {
                //此时下标不在滑动窗口内，则说明移动的窗口刚好移除了最大值，这时候就需要重新寻找最大值
                maxValue=nums[i];
                for (int j = i; j < i + k; j++) {
                    if(maxValue<nums[j]){
                        maxValue=nums[j];
                        maxIndex=j;
                    }
                }
            }
            result[i]=maxValue;
        }


        return result;
    }
}



























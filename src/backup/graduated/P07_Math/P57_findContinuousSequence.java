package BackUp.graduated.P07_Math;

import java.util.ArrayList;

public class P57_findContinuousSequence {
    /**
     * 首先定义滑动窗口变量
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        //用滑动窗口解法
        int left=1;//左边界
        int right=1;//右边界
        int sum=0;//滑动窗口里面的数字之和
        ArrayList<int[]> list = new ArrayList<int[]>();

        while (left<=target/2){
            if(sum<target){//如果和小于目标，则右移
                sum +=right++;
            }
            else if(sum>target){//如果和大于目标，则左移
                sum -=left++;
            }
            else {//如果刚好等于目标，则添加
                int []arr= new int[right-left];
                for (int i = left; i <right ; i++) {//i++是在一趟结束完了之后
                    arr[i-left]=i;
                }
                list.add(arr);
                sum -=left++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        new P57_findContinuousSequence().findContinuousSequence(15);
    }

}

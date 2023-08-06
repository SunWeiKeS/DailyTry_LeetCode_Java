package BackUp.graduated.P03_Array;

public class P0414HUAWEI_45jump {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;

    }

    public int jump2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int steps = 0;
        int maxPosition=0;//最远位置
        int end=0;//一次可到达的最远位置
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition=Math.max(maxPosition, i+nums[i]);

            if(i==end){
                //一个step用完了
                end=maxPosition;
                steps++;
            }

        }

        return steps;
    }
}






















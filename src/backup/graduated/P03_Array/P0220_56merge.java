package BackUp.graduated.P03_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class P0220_56merge {
    public int[][] merge1(int[][] intervals) {
        //首先处理特殊情况
        if(intervals.length==0)return new int[0][2];

        //对数组进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //设置一个新的list用于保持
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int L=intervals[i][0];
            int R=intervals[i][1];
            if(list.size()==0||list.get(list.size()-1)[1]<L){
                //每次添加进去的都是按照顺序的，这时候要保证添加进去的右边小于即将进去的左边
                list.add(new int[]{L,R});
            }else {
                //这种情况就需要进行比较了
                list.get(list.size()-1)[1]=Math.max(R,list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}

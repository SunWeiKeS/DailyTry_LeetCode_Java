package backup.graduated.P07_Math;

public class P60_twoSum {
    /**
     根据动态规划的思想分解子问题。
     我们可以把n个骰子的点数分解为n-1个骰子的点数加上一个骰子的点数。
     根据1个骰子的点数概率数组求出2的点数概率数组，根据2的点数概率数组求出3的点数概率数组....直到求出n的点数。
     那么我们要怎么根据n-1个骰子的点数概率数组求出n个骰子的点数概率数组呢？
     我们假设n=2。
     则我们已知1的点数概率数组为{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
     我们要求的2个骰子，可以分解为n-1个骰子和1个骰子
     同时易知2个骰子的点数概率数组长度为2*5+1。

     状态转移方程： tmp[x+y]+=pre[x]*num[y]
     */
    public double[] twoSum(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};


        for (int i = 2; i <=n; i++) {
            double []tmp=new double[5*i+1];
            for (int j = 0; j < pre.length; j++) {//n-1个骰子的点数
                for (int u = 0; u < 6; u++) {//加上一个骰子的点数
                    tmp[j+u]+=pre[j]/6;
                }
            }
            pre=tmp;
        }

        return pre;
    }
}

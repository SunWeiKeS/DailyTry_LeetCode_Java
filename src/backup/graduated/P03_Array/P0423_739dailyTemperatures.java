package backup.graduated.P03_Array;

import java.util.LinkedList;

/**
 * @Author:vic
 * @Date:21-4-23
 * @Content:
 */
public class P0423_739dailyTemperatures {
    public int[] dailyTemperatures1(int[] T) {
        int len=T.length;
        int[] res = new int[len];
        res[len-1]=0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j <len ; j++) {
                if(T[j]>T[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }
    public int[] dailyTemperatures(int[] T) {
        int len=T.length;
        int[] res = new int[len];
        LinkedList<Integer> stack = new LinkedList<>();//存放的是下标
        for (int i = 0; i < T.length; i++) {
            int wenDu=T[i];
            while (!stack.isEmpty()&&wenDu>T[stack.peek()]){
                int index=stack.pop();//弹出下标
                res[index]=i-index;
            }
            stack.push(i);//把下标放进栈中
        }
        return res;
    }
}

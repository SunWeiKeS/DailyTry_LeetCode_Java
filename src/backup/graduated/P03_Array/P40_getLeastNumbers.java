package BackUp.graduated.P03_Array;

import java.util.Arrays;

public class P40_getLeastNumbers {
    public int[] getLeastNumbers1(int[] arr, int k) {
        //使用预设定好的排序方法
        if (arr==null)
            return null;

        Arrays.sort(arr);
        int []vec = new int[k];
        for (int i = 0; i < k; i++) {
            vec[i]=arr[i];
        }

        return vec;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //使用快速排序
        //使用预设定好的排序方法
        if (arr==null)
            return null;
        int []vec = new int[k];


        return null;
    }
}

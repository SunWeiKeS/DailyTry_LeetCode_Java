package backup.graduated.P05_DynamicPlanning;
//题目：给n个有序字符串(仅小写字母,ASCII序递增),求所能拼接的最长有序子串的长度。
//例如["aaa","bcd","zzz","bcdef","def"]所能拼接出的最长有序子串为
//aaa,bcd,def,zzz拼接出的aaabcddefzzz长度为12
//时间：1h

import java.util.Arrays;

public class P0322_alibabFindLongest {
    //例如["aaa","bcd","zzz","bcdef","def"]所能拼接出的最长有序子串为
//aaa,bcd,def,zzz拼接出的aaabcddefzzz长度为12
    public static void main(String[] args) {
        int max=strLength(new String[]{"aaa","bcd","bcddddddddddef","def","zzz"});
        System.out.println(max);
    }
    public static int strLength(String[]arr){
        //首先给的都是有序的，那我们先获取每一个的首部、尾巴？
        //我们取第一个的时候肯定是找ascii最小的一个
        Arrays.sort(arr);//排完序就可以一个一个找了
        int[]dp=new int[arr.length];//维护一个动态的数组

        dp[0]=arr[0].length();
        int max=0;
        int location=0;//位置

        for (int i = 1; i < arr.length; i++) {
            location=i;//记录我当前的位置
            int tmp=0;//这个是用来回溯的值
            for (int j = i-1; j >=0 ; j--) {
                //向前迭代
                int start=arr[i].charAt(0);//当前的第一个
                int least_end= arr[j].charAt(arr[j].length()-1);//当前的上一个的尾巴
                if (start>=least_end &&dp[j]>tmp){
                    //首位必须是衔接的，并且当前的dp比tmp大
                    tmp=dp[j];
                    location=j;
                }
            }
            dp[i]=dp[location]+arr[i].length();
            max=Math.max(max, dp[i]);
        }

        return max;
        
    }

}
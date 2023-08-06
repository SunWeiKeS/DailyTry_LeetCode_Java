package backup.graduated.P06_String;

import java.util.Random;

/**
 * @Author:vic
 * @Date:21-4-16
 * @Content:
 */
public class P0416_528pickIndex {

}
class Solution {
    int arr[];
    public Solution(int[] w) {
        arr= new int[w.length];
        int sum=0;
        for (int i = 0; i < w.length; i++) {
            sum+=w[i];
            arr[i]=sum;
        }
    }
    public int pickIndex() {

        Random random = new Random();
        int randomNum = random.nextInt(arr[arr.length-1]) + 1;

        int left=0,right=arr.length-1;
        while (left<right){
            int mid=left+((right-left)>>1);
            if(arr[mid]==randomNum){
                return mid;
            }else  if (arr[mid]>randomNum){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
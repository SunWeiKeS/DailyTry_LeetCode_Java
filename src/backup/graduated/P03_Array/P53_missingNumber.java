package BackUp.graduated.P03_Array;

public class P53_missingNumber {
    public int missingNumber1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(i !=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    public int missingNumber(int[] nums) {

        int i=0;
        int j=nums.length;
        while (i!=j){
            int num=(i+j)/2;
            if(num ==nums[num]){
                //这时候说明在右边
                i=num+1;
            }else {
                //这时候说明在左边
                j= num;
            }
        }
        return i;
    }
}

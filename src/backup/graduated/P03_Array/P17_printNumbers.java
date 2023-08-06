package BackUp.graduated.P03_Array;

public class P17_printNumbers {
    public int[] printNumbers(int n) {
        if(n<=0){
            return null;
        }
        int length= (int) (Math.pow(10,n)-1);
        int [] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i]=i+1;
        }
        return res;
    }


}

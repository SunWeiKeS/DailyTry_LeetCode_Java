package backup.graduated.P07_Math;

public class P15_hammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        String s = Integer.toBinaryString(n);
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            char a=s.charAt(i);
            if(a=='1')
                res++;

        }
        return res;
    }
    public int hammingWeight2(int n) {//位移比较法
        int res=0;
        while (n!=0){
            int temp= n&1;
            res +=temp;
            n=n>>>1;
        }

        return res;
    }
    public int hammingWeight(int n) {//位移比较法
        int res=0; 
        while (n!=0){
            res++;
            n &=n-1;
        }

        return res;
    }
    public static void main(String[] args) {
        P15_hammingWeight demo= new P15_hammingWeight();
        System.out.println(demo.hammingWeight(31));

    }

}

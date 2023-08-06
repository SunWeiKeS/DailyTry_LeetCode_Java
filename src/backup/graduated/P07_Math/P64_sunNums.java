package BackUp.graduated.P07_Math;

public class P64_sunNums {
    public int sumNums(int n) {

        return n==0?0:n+sumNums(n-1);
    }

    public static void main(String[] args) {

    }
}

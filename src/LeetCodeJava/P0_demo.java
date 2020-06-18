package LeetCodeJava;

public class P0_demo {
    public static void main(String[] args) {
        int []a ={1,2,3,45};
        int []b=a.clone();
        b[2]=4342;
        for (int i = 0; i <b.length-1; i++) {
            System.out.println(b[i]);

            System.out.println(a[i]);
        }
    }
}

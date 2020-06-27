package LeetCodeJava;

public class P461_hammingDistance {
	 public static int hammingDistance(int x, int y) {
	       
		 return Integer.bitCount(x^y);
	    }
	 public static void main(String[] args) {
		 for (int i = 1; i <= 5; i++) {

			    int count = Integer.bitCount(i);

			    String str=Integer.toBinaryString(i);

			    System.out.print(i+" 转换为二进制为 "+str+" 表示     形式的1位的数量为 ");
			 
			    System.out.println(count);

			}
		 System.out.println(hammingDistance(2,2));
	}
}

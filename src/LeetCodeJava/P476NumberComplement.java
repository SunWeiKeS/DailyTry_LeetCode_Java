package LeetCodeJava;

public class P476NumberComplement {
	public static int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}
	public static void main(String[] args) {
		System.out.println(Integer.highestOneBit(9));
	}
}

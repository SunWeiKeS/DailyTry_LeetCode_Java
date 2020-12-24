package com.vicsun.LeetCodeJava;

public class P566_ReshapethMatrix {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int m=nums.length;int n=nums[0].length;

		if(r*c ==m*n){
			int [][]temp = new int[r][c];
			for (int i = 0; i < r*c; i++) {
				temp[i/c][i%c]=nums[i/n][i%n];
			}
			return temp;
		}else {
			return nums;
		}

	}
	public static void main(String[] args) {
		int [][]demo = {{1,2,5,6},{3,4,6,9}};
		int[][]temp=matrixReshape(demo, 8, 1);
		System.out.println(temp.length);
		System.out.println(temp[0].length);
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j]+"  ");
			}
			System.out.println();
		}
	}
}

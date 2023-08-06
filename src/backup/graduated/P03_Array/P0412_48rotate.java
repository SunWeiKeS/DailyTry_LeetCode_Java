package BackUp.graduated.P03_Array;

/**
 * @Author:vic
 * @Date:21-4-12
 * @Content:
 */
public class P0412_48rotate {
    public void rotate(int[][] matrix) {
        /**
         * 将一个矩阵顺时针旋转90度
         * 1 尝试一下水平反转
         * 2 对角线反转
         */
        if(matrix.length==0||matrix.length==1||matrix.length!=matrix[0].length)
            return;
        int len=matrix.length;

        //水平反转，则i动，j不变
        for (int i = 0; i < len/2; i++) {
            int []temp=matrix[i];
            matrix[i]=matrix[len-i-1];
            matrix[len-i-1]=temp;
        }

        //对角线 ij互换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}

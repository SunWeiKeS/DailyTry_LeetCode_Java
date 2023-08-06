package backup.graduated.P03_Array;

public class P04_findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //先判断特殊情况
        if(matrix==null||matrix.length==0){
            return false;
        }

        //在右上角位置进行二叉树查找
        int n1=matrix.length; //行
        int n2=matrix[0].length; //列
        int left=n2-1;
        int down= 0;
        while(left>=0&&down<=n1-1){
            if(matrix[down][left]==target)
                return true;
            else if(matrix[down][left]> target)
                left--;
            else
                down++;
        }

        return false;
    }
}


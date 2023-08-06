package BackUp.graduated.P03_Array;

public class P29_spiralOrder {
    /**
     * 当数组为空的时候直接返回一个空白的矩阵
     * 初始化矩阵的上下左右四个边界。用于打印返回的结果res矩阵
     * 循环打印顺序：
     *          从上左，到上右，遍历完，上边界+1，判断边界是否相同，相同则退出 top>bottom
     *          从上右，到下右，遍历完，右边界-1，判断边界是否相同，相同则退出 right< left
     *          从下右，到下左，遍历完，下边界-1，判断边界是否相同，相同则退出 bottom< top
     *          从下左，到上左，遍历完，左边界+1，判断边界是否相同，相同则退出 left>right
     *
     *
     */
    public int[] spiralOrder(int[][] matrix) {

        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return new int[0];
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int[]res=new int[(matrix[0].length)*(matrix.length)];
        int index_res=0;
        while (true){
            for (int i = left; i <= right; i++) res[index_res++]=matrix[top][i];
            if(++top>bottom) break;

            for (int i = top; i <= bottom; i++) res[index_res++]=matrix[i][right];
            if(--right<left) break;

            for (int i = right; i >= left; i--) res[index_res++]=matrix[bottom][i];
            if(--bottom<top) break;

            for (int i = bottom; i >= top; i--) res[index_res++]=matrix[i][left];
            if(++left>right) break;
        }

        return res;
    }
}



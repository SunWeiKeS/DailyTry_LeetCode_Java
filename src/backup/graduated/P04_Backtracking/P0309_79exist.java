package BackUp.graduated.P04_Backtracking;

public class P0309_79exist {
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int index_length = board[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < index_length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;//从word单词的第0号位置开始寻找
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        //index长度超过word的时候说明已经完全找到了
        if (index >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if (word.charAt(index) != board[i][j]) {
            return false;//word单词的index处的值与数组的不同
        }
        //接下来的情况说明这两个是相同的
        //在寻找之前我们需要将当前位置的元素滞空
        board[i][j]='0';
        if(
                dfs(board,word,index+1, i+1, j)||
                dfs(board,word,index+1, i-1, j)||
                dfs(board,word,index+1, i, j+1)||
                dfs(board,word,index+1, i, j-1)
        ){
            return true;//但凡一个位置找到了就找到了
        }
        board[i][j]=word.charAt(index);

        return false;
    }
}

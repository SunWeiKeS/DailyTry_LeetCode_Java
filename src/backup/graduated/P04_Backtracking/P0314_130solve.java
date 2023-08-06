package backup.graduated.P04_Backtracking;

public class P0314_130solve {
    public void solve(char[][] board) {
        //处理特殊情况
        //边界上的O扩散处理O变为"-"
        //其余如发现是O直接变为X，如果发现是- 则变为X

        if (board.length == 0 || board[0].length == 0 || board == null)
            return;
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length-1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='-')
                    board[i][j]='O';
            }
        }

    }

    public void dfs(char[][] board, int i, int j) {
        //深度遍历感染每一个节点
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;

        board[i][j]='-';
        dfs(board,i-1, j);
        dfs(board,i+1, j);
        dfs(board,i, j-1);
        dfs(board,i, j+1);

    }
}

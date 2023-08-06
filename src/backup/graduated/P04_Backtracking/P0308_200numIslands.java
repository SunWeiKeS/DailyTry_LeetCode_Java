package backup.graduated.P04_Backtracking;

public class P0308_200numIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int length = grid.length;
        int index_length = grid[0].length;

        int numLands = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < index_length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numLands++;
                }
            }
        }
        return numLands;
    }

    public void dfs(char[][] grid, int i, int j) {//函数存在的目的是感染，使得周围所有的都变为0
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';//当前岛屿归0
        dfs(grid, i - 1, j);//周围四个地方的岛也归0
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

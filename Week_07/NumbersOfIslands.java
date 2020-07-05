/**
 * @author Zeng
 * @date 2020/7/4 23:11
 */
public class NumbersOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int res = 0, row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid, x, y);
                }
            }
        }
        return res;
    }

    public void dfs(int a, int b, char[][] grid, int[] x, int[] y) {
        grid[a][b] = '0';
        for (int i = 0; i < 4; i++) {
            int nextX = a + x[i];
            int nextY = b + y[i];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)
                continue;
            if (grid[nextX][nextY] == '1')
                dfs(nextX, nextY, grid, x, y);
        }
    }
}

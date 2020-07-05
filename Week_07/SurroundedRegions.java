/**
 * @author Zeng
 * @date 2020/7/4 23:41
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        // 1. 判空
        if (board == null || board.length == 0)
            return ;
        // 2. DFS -> 和边界联通的"O"标识出来,改为"-"
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean edge = isEdge(i, j, board);
                if (edge && board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }
        // 3. 将未被标识的"O"改为"X",其它被标识的改为"O"
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '-')
                    board[i][j] = 'O';
            }
        }
    }
    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O')
            return ;
        board[x][y] = '-';
        dfs(x + 1,  y, board);
        dfs(x - 1, y, board);
        dfs(x, y + 1, board);
        dfs(x, y - 1, board);
    }

    public boolean isEdge(int i, int j, char[][] board) {
        return (i == 0) || (j == 0) || (i == board.length - 1) || (j == board[0].length - 1);
    }
}

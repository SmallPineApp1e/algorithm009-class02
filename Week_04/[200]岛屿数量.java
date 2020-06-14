//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return res;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(grid, isVisited, direction, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, boolean[][] isVisited, int[][] direction, int i, int j) {
        // terminator
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return ;
        if (isVisited[i][j])
            return ;
        // process logic
        isVisited[i][j] = true;
        // drill down
        dfs(grid, isVisited, direction, i + direction[0][0], j + direction[0][1]);
        dfs(grid, isVisited, direction, i + direction[1][0], j + direction[1][1]);
        dfs(grid, isVisited, direction, i + direction[2][0], j + direction[2][1]);
        dfs(grid, isVisited, direction, i + direction[3][0], j + direction[3][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

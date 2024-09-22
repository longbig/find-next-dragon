package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/22 16:41
 * @description 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class LeetCode200 {

    //DFS遍历就行，标记遍历过的格子
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        //超出了网格范围，直接返回
        if (!inArea(grid, i, j)) {
            return;
        }
        if (grid[i][j] == '2' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '2';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private boolean inArea(char[][] grid, int i, int j) {
        return i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1;
    }
}

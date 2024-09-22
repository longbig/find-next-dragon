package leetcode2024.easy;

/**
 * @author yuyunlong
 * @date 2024/9/22 16:57
 * @description 463. 岛屿的周长
 *
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 */
public class LeetCode463 {

    //DFS框架解决，注意只有遇到水，和遇到边界时才需要加周长，遍历过的格子不需要管
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return
        dfs(grid, i + 1, j) +
        dfs(grid, i - 1, j) +
        dfs(grid, i, j + 1) +
        dfs(grid, i, j - 1);
    }

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1;
    }
}

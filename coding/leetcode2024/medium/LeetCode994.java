package leetcode2024.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyunlong
 * @date 2024/10/1 23:55
 * @description 994. 腐烂的橘子
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class LeetCode994 {

    //这题需要用广度优先遍历方法，用到队列
    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            count++;
            while (size > 0) {
                int[] point = queue.poll();
                size--;
                int i = point[0], j = point[1];
                //先染色，能染的加入队列
                if (inArea(grid, i + 1, j) && grid[i + 1][j] == 1) {
                    queue.add(new int[]{i + 1, j});
                    grid[i + 1][j] = 2;
                    fresh--;
                }
                if (inArea(grid, i - 1, j) && grid[i - 1][j] == 1) {
                    queue.add(new int[]{i - 1, j});
                    grid[i - 1][j] = 2;
                    fresh--;
                }
                if (inArea(grid, i, j + 1) && grid[i][j + 1] == 1) {
                    queue.add(new int[]{i, j + 1});
                    grid[i][j + 1] = 2;
                    fresh--;
                }
                if (inArea(grid, i, j - 1) && grid[i][j - 1] == 1) {
                    queue.add(new int[]{i, j - 1});
                    grid[i][j - 1] = 2;
                    fresh--;
                }
            }
        }


        //再遍历一遍，还存在新鲜橘子就返回-1
        if (fresh > 0) {
            return -1;
        }
        return count;
    }
    

    private boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}

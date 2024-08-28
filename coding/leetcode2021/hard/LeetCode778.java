package leetcode2021.hard;

/**
 * @author yuyunlong
 * @date 2021/1/30 1:31 下午
 * @description  水位上升的泳池中游泳
 */
public class LeetCode778 {

    private int N;

    private int[][] directs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;

        int right = N * N - 1;
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[N][N];

            if (grid[0][0] <= mid && dfs(grid, 0, 0, visited, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int mid) {
        visited[x][y] = true;
        for (int[] direct : directs) {
            int newX = x + direct[0];
            int newY = y + direct[1];

            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= mid) {
                if (newX == N -1 && newY == N - 1) {
                    return true;
                }
                if (dfs(grid, newX, newY, visited, mid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        if(newX >= 0 && newX < N && newY >= 0 && newY < N) {
            return true;
        }
        return false;
    }


}

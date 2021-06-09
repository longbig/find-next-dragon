package meituan;

import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/7 7:11 下午
 * @description 顺时针打印矩阵
 */
public class LeetCode054 {

    //右下左上
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int nowDir = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int total = matrix.length * matrix[0].length;
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;

            //非边界值位置
            int newRow = row + directions[nowDir][0];
            int newCol = col + directions[nowDir][1];

            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length
                    || visited[newRow][newCol]) {
                nowDir += 1;
                if (nowDir >= 4) {
                    nowDir = 0;
                }
            }


            row += directions[nowDir][0];
            col += directions[nowDir][1];
        }
        return res;
    }


}

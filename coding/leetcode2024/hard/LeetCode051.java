package leetcode2024.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
public class LeetCode051 {

    /**
     * 灵神的解法： https://leetcode.cn/problems/n-queens/?envType=study-plan-v2&envId=top-100-liked
     *
     * 每一行一定会插入，
     * 插入新皇后时，需要判断三层：列上是否有皇后， 左下到右上是否有， 左上到右下对角线是否有
     * 为了实现O（1）时间复杂度的判断：
     * 列数组：记录该列是否已经放了皇后
     * 左斜线数组： row + col 的值是一样，因此判断插入位置的row+col的和，是否在数组中存在，存在说明该斜线上已有皇后
     * 右斜线数组： row - col 的值是一样的，
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int row = 0;
        int[] path = new int[n];
        boolean[] colmnChoosed = new boolean[n];
        boolean[] rowAddCol = new boolean[2 * n - 1];
        boolean[] rowSubCol = new boolean[2 * n - 1];
        dfs(row, n, path, result, colmnChoosed, rowAddCol, rowSubCol);
        return result;

    }

    private void dfs(int currentRow, int n, int[] path, List<List<String>> result, boolean[] colmnChoosed,
                     boolean[] rowAddCol, boolean[] rowSubCol) {
        if (currentRow == n) {
            //已有结果，存储后回溯
            result.add(build(path, n));
            return;
        }
        //遍历列，判断可插入位置
        for (int i = 0; i < n; i++) {
            //可插入时
            //这里要注意：右\ 斜线处理时，要加上n - 1 让下标从0开始
            if (!colmnChoosed[i] && !rowAddCol[currentRow + i] && !rowSubCol[currentRow - i + n - 1]) {
                //这个会被覆盖，所以不需要恢复现场
                path[currentRow] = i;
                colmnChoosed[i] = rowAddCol[currentRow + i] = rowSubCol[currentRow - i + n - 1] = true;
                dfs(currentRow + 1, n, path, result, colmnChoosed, rowAddCol, rowSubCol);
                //恢复现场
                colmnChoosed[i] = rowAddCol[currentRow + i] = rowSubCol[currentRow - i + n - 1] = false;
            }
        }

    }

    private List<String> build(int[] path, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer line = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (j == path[i]) {
                    line.append("Q");
                } else {
                    line.append(".");
                }
            }
            result.add(line.toString());
        }
        return result;
    }
}

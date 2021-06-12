package leetcode.medium;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yuyunlong
 * @date 2021/6/10 3:02 下午
 * @description 最大正方形
 */
public class LeetCode221 {

    /**
     * 动态规划思路：dp(i, j)表示以（i， j）为右下角的正方形的最大长度，它的值由左边，上边，左上边的dp值决定
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i - 1][j - 1], temp) + 1;
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {{'1','0','1','0','0'}, {'1', '0', '1','1',1},
//                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'0','1'}, {'1', '0'}};
        LeetCode221 test = new LeetCode221();
        System.out.println(test.maximalSquare(matrix));
    }
}

package leetcode2024.medium;

/**
 * @author Administrator
 * @date 2024/9/30 10:03
 * @description 130. 被围绕的区域
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
 *
 * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
 * 区域：连接所有 'O' 的单元格来形成一个区域。
 * 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
 * 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。
 */
public class LeetCode130 {

    //根据题目要求，对4个边缘进行DFS搜索，标记与边缘O相连的所有O，再遍历一遍，没有被标记的O则改为X
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        //只遍历边界
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (!inArea(board, i, j)) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    private boolean inArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}

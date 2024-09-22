package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/22 17:16
 * @description 419. 棋盘上的战舰
 *
 * 给你一个大小为 m x n 的矩阵 board 表示棋盘，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在棋盘 board 上放置的 舰队 的数量。
 */
public class LeetCode419 {

    //还是DFS解题套路，只需要往后和往下深度就行了
    public int countBattleships(char[][] board) {
        if (board == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] board, int i, int j) {
        if (!inArea(board, i, j)) {
            return;
        }
        if (board[i][j] != 'X') {
            return;
        }
        board[i][j] = 'Z';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }

    private boolean inArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}

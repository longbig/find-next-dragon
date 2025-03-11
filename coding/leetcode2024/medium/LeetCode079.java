package leetcode2024.medium;

/**
 * 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LeetCode079 {

    public static void main(String[] args) {
        LeetCode079 leetCode079 = new LeetCode079();

        char[][] board = {
                {'a', 'b'},{'c', 'd'}
        };
        String word = "cdba";
//        String current = "ASA";
//        System.out.println(word.startsWith(current));
        System.out.println(leetCode079.exist(board, word));
    }

    /**
     * 递归，回溯法，加上剪枝
     *
     * 边界不要，走过的路不要，到了字符串长度也停止
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                boolean oneResult = checkExist(board, word, i, j, k);
                if (oneResult) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkExist(char[][] board, String word, int i, int j, int k) {
        //判断是否超过边界，是否需要继续走？
        boolean inBoard = (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
        if (!inBoard || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] = '\0';
        if (k == word.length() - 1) {
            return true;
        }
        //四个方向的深度遍历
        boolean up = checkExist(board, word, i + 1, j, k + 1);
        boolean down = checkExist(board, word, i - 1, j, k + 1);
        boolean right = checkExist(board, word, i, j + 1, k + 1);
        boolean left = checkExist(board, word, i, j - 1, k + 1);
        board[i][j] = word.charAt(k);
        return up || down || right || left;
    }


}

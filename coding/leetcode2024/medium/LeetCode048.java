package leetcode2024.medium;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2024/8/11 15:13
 * @description 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class LeetCode048 {

    /**
     * 直接拷贝一份数组，在原数组上修改
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] temp = new int[x][y];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        //改原数组
        for (int i = 0; i < temp.length; i++) {
            int j = 0;
            //对应原数组的最后列
            for (int k = matrix.length - 1; k >= 0; k--) {
                int z = 0;
                while (j < temp.length) {
                    matrix[z++][temp.length - 1 - i] = temp[i][j++];
                }
            }
        }

    }

    public static void main(String[] args) {
        LeetCode048 leetCode048 = new LeetCode048();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        leetCode048.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

}

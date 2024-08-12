package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/8/10 18:42
 * @description 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class LeetCode073 {

    /**
     * 思路：for循环遍历二维数组，然后用两个数组m， n，记下元素为0的坐标
     * 之后，for循环遍历改二维数组元素为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int m = matrix.length; //行
        int n = matrix[0].length;
        int[] numsM = new int[m];
        int[] numsN = new int[n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    numsM[i] = 1;
                    numsN[j] = 1;
                }
            }
        }
        //遍历完知道了所有0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (numsM[i] == 1 || numsN[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


}

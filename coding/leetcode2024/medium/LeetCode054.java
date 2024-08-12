package leetcode2024.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2024/8/10 19:09
 * @description 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * We go boundary by boundary and move inwards.
 * That is the essential operation. First row, last column, last row, first column,
 * and then we move inwards by 1 and repeat.
 * That's all. That is all the simulation that we need.
 */
public class LeetCode054 {

    /**
     * 解题思路，设置4个边界，每走完一个方向，就将该边界移动一层
     * 上下交叉，左右交叉时，退出循环
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        //初始化边界
        int left = 0;
        int down = matrix.length - 1;
        int up = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        //循环，直到边界交叉才退出
        while (true) {
            //上
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            if (++up > down) break;

            //右
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) break;

            //下
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            if (--down < up) break;

            //左
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 10},
                {7, 8, 9, 11}
        };
        LeetCode054 leetCode054 = new LeetCode054();
        List<Integer> list = leetCode054.spiralOrder(array);
        System.out.println(list);
    }
}

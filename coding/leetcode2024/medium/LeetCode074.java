package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/16 16:42
 * @description 74. 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class LeetCode074 {

    //用二分查找的思路，把整个矩阵看作是一个递增数组
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] < target) {
                low = mid + 1;
            } else if (matrix[x][y] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;

    }

    //从右上角开始，直到遍历到左下角
    public boolean searchMatrixZijian(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int row = 0, clomn = matrix[0].length - 1;
        while (row < matrix.length && clomn >= 0) {
            if (matrix[row][clomn] > target) {
                clomn--;
            } else if (matrix[row][clomn] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;

    }
}

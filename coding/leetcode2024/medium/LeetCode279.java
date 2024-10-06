package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/10/6 11:33
 * @description 279. 完全平方数
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class LeetCode279 {

    //动态规划的思路，f(i)表示总和到i需要的个数， 存在小于i的数j，满足f(i) = 1 + min(f(i - j * j))
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = 1 + minn;
        }
        return f[n];
    }
}

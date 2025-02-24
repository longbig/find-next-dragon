package leetcode2024.medium;

/**
 * 416 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class LeetCode416 {

    /**
     * 动态规划思路求解，dp[i][j]主要思路是从数组[0, i]里取数，是否相加和为j， 这里j的最终目标是数组和的一半
     * 需要考虑的边界情况比较多，尤其记住要求数组中最大数不超过sum / 2
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        //至少需要2个数
        if (n < 2) {
            return false;
        }
        int sum = 0, maxValue = nums[0];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxValue = Math.max(maxValue, nums[i]);
        }
        //和为奇数的情况，是无法拆分2个等和子集的
        if (sum % 2 != 0) {
            return false;
        }
        //还需要记录数组中的最大值，如果最大值大于target，则无法拆分
        int target = sum / 2;
        if (maxValue > target) {
            return false;
        }

        //初始化dp数组
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        //执行判断过程
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i] <= j) {
                    //可以加上也可以不加上nums[i]，两个有其中一个能满足就返回TRUE
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //返回结果
        return dp[n - 1][target];
    }
}

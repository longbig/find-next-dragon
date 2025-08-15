package leetcode2025;

/**
 * @author yuyunlong
 * @date 2025/8/2 22:24
 * @description
 */
public class LeetCode198 {

    //f(n) = max(f(n-1), f(n-2) + nums[n]);
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];


    }
}

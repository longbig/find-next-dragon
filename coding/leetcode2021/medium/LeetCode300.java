package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/5/26 4:31 下午
 * @description 最长递增子序列
 */
public class LeetCode300 {

    /**
     * 方法1：动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        LeetCode300 test = new LeetCode300();
        System.out.println(test.lengthOfLIS1(nums));
    }
}

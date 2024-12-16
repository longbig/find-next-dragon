package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/7 17:13
 * @description 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
//        if (nums == null) {
//            Object
//            return 0;
//        }

        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;

            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    len = Math.max(dp[j] + 1, len);
                } else {
                    len = Math.max(dp[i], len);
                }
            }
            dp[i] = len;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;

    }
}

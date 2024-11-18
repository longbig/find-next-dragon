package leetcode2024.medium;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 */
public class LeetCode152 {

    /**
     * 动态规划的方法，注意会有负数，所以需要维护两个dp数组，另一个维护的是最小的负数
     */
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        long[] maxArray = new long[nums.length];
        long[] minArray = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxArray[i] = nums[i];
            minArray[i] = nums[i];
        }
        int maxValue = (int) maxArray[0];
        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = Math.max(Math.max(maxArray[i - 1] * nums[i], nums[i]), minArray[i - 1] * nums[i]);
            minArray[i] = Math.min(Math.min(minArray[i - 1] * nums[i], nums[i]), maxArray[i - 1] * nums[i]);
            maxValue = (int) Math.max(maxValue, maxArray[i]);
        }
        return maxValue;



    }
}

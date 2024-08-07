package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/8/7 23:01
 * @description 最大子数组和  子串问题
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class LeetCode053 {

    /**
     * 子串问题解法， 用右边累加的值 - 左边累加的值，就等于这个子串的值了。
     * 用这个特性计算
     * 然后减法的时候，只需要计算左边最小的值就行，这样一减，得到的子串肯定数值最大
     *
     * 第一次做有个报错的点，判断左边最小值时，不要把for循环当前遍历到的值加上，只算指针左边数组的值即可
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0], minSum = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            int maxFori = Math.max(sum, sum - minSum);
            maxResult = Math.max(maxResult, maxFori);

            minSum = Math.min(sum, minSum);

        }
        return maxResult;
    }

    /**
     * 官方解法，动态规划的思路，方法非常巧妙
     * @param nums
     * @return
     */
    public int maxSubArrayForLeetCode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, maxResult = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxResult = Math.max(maxResult, pre);
        }

        return maxResult;
    }

    public static void main(String[] args) {
        LeetCode053 leetCode053 = new LeetCode053();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = leetCode053.maxSubArray(nums);
        System.out.println(result);
    }
}

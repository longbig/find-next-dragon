package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/8/10 18:26
 * @description 除自身以外数组的乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class LeetCode238 {

    /**
     * 解题思路，位置i的乘积可以看做 是 左右两部分数组 乘积的结果
     * 先初始化两个数组L R，得到位置i的左右子数组乘积初始值，
     * 最后遍历相乘就行
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                L[i] = 1;
            } else {
                L[i] = L[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                R[i] = 1;
            } else {
                R[i] = R[i + 1] * nums[i + 1];
            }
        }
        //结果
        for (int i = 0; i < nums.length; i++) {
            nums[i] = L[i] * R[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
        int[] nums = new int[]{1,2,3,4};
        leetCode238.productExceptSelf(nums);
    }
}

package leetcode2024.hard;

/**
 * @author yuyunlong
 * @date 2025/2/19 22:41
 * @description 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2]中的数字都在数组中。
 */
public class LeetCode041 {
    /**
     * 解题思路：
     * 遍历第一遍，如果元素在[1，N]之间，N为数组长度，那么交换元素位置，放在正确顺序的位置，
     * 注意交换后，另一个元素可能也是在[1, N]之间，需要继续交换，直到交换后的元素不在[1, N]之间
     * 上面的过程可能出现死循环，就是nums[i] == nums[x - 1]时，需要判断两个值如果相等，就终止交换
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && (nums[i] != nums[nums[i] - 1])) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //第二次遍历数组，因为第一个正数只能在[1, N]之间，所以如果该位置不是对应的值，就返回该值，否则返回N + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

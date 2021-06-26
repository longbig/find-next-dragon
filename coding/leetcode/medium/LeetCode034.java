package leetcode.medium;

/**
 * @author yuyunlong
 * @date 2021/6/25 8:53 下午
 * @description 在排序数组中找元素第一个和最后一个位置，不存在时返回-1
 */
public class LeetCode034 {

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target);
        int rightIdx = binarySearch(nums, target + 1) - 1;
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{leftIdx, rightIdx};
    }

    /**
     * 思路：先找 >= target第一个值的下标，再找 > target的第一个值的下标
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}

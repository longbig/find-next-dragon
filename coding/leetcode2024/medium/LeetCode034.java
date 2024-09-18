package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/16 17:16
 * @description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode034 {
    /**
     * 搞2次二分查找，一次找最左边，一次找最右边，注意重点位置，比较==target时，还需要继续遍历，first和last更新
     */
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        if (nums == null) {
            return new int[]{first, last};
        }
        int left = 0, right = nums.length - 1;
        //找最左边
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //第二次遍历
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{first, last};

    }
}

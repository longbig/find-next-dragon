package leetcode2024.medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class LeetCode153 {

    /**
     * 要求logN的时间复杂度，
     * 解题思路：二分查找的思路， 需要判断将中间值与 数组的最后一个元素比较， 从而判断出当前区间是在最小值的左侧还是右侧
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];

    }
}

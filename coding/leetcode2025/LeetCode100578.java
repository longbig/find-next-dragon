package leetcode2025;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2025/7/27 21:28
 * @description
 */
public class LeetCode100578 {

    //排序数组，重复取最大的2个数，和最小的1个数，得到中位数
    public long maximumMedianSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = -1, right = nums.length;
        long sum = 0;
        while (left < (right - 1)) {
            left++;
            right -= 2;
            sum += nums[right];
        }
        return sum;
    }
}

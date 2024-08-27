package leetcode2021.easy;

/**
 * @author yuyunlong
 * @date 2021/4/18 12:32 下午
 * @description 删除有序数组中的重复项
 */
public class LeetCode026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        while (end < nums.length) {
            while (end < nums.length && nums[start] == nums[end]) {
                end++;
            }
            ++start;
            if (start < nums.length) {
                nums[start] = nums[end];
            }
        }
        return start + 1;

    }

}

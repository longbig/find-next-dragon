package leetcode2025;

/**
 * @author yuyunlong
 * @date 2025/7/26 15:32
 * @description
 */
public class LeetCode027 {

    //和26题一样的思路，用两个指针
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        while (end < nums.length) {
            if (nums[end] != val) {
                nums[start] = nums[end];
                start++;
            }
            end++;
        }
        return start;
    }
}

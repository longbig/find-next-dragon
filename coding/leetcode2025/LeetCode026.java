package leetcode2025;

/**
 * @author yuyunlong
 * @date 2025/7/26 15:22
 * @description
 */
public class LeetCode026 {

    //思路：用一个单独的指针指向新数组，表示结果组的下标，然后用另一个指针遍历数组，最后返回结果指针下标+1
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                end++;
                continue;
            }
            //现在start和end指向的数据不等
            nums[++start] = nums[end];
            end++;
        }
        return start + 1;

    }
}

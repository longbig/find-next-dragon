package leetcode2024.easy;

/**
 * @author yuyunlong
 * @date 2024/8/4 23:40
 * @description 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class LeetCode283 {

    /**
     * 思路：遍历数组，两个指针，一个指针i用于遍历数组
     * 另一个指针j从下标0开始，当前一个指针i遇到非0元素时，则交换i 和 j 的值，指针j往前移动一位。
     * 指针j的作用就是用于存放非0元素用的
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }


    public static void main(String[] args) {
        LeetCode283 leetCode283 = new LeetCode283();
        int[] nums = new int[]{0,1,0,3,12};
        leetCode283.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

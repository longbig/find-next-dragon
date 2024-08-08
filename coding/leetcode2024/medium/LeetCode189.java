package leetcode2024.medium;

/**
 * @author Administrator
 * @date 2024/8/8 8:51
 * @description 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class LeetCode189 {

    /**
     * 数组扩张2倍，向右轮转k个位置，就是取 num.length - k 到 2 * num.length - k 的长度，
     * 注意k可能大于 nums.length，需要提前取模
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] newNums = new int[2 * nums.length];
        k = k % nums.length;
        int index = 0;
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = nums[index++];
            if (index == nums.length) {
                index = 0;
            }
        }

        index = 0;
        for (int i = nums.length - k; i < 2 * nums.length - k; i++) {
            nums[index++] = newNums[i];
        }
    }

    /**
     * 官方解法，翻转数组
     * 注意：翻转数组用的双指针解法
     * @param nums
     * @param k
     */
    public void rotateForLeetCode(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        LeetCode189 leetCode189 = new LeetCode189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 10;
        leetCode189.rotateForLeetCode(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}

package leetcode2024.medium;

/**
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class LeetCode075 {

    /**
     * 双指针解法，一个指针交换0，另一个指针交换2， 注意交换尾部2的时候，如果换回来的是0，指针需要回退，再把0挪到前面
     * 要求常量空间
     * @param nums
     */
    public void sortColors(int[] nums) {
        int pre = 0, tail = nums.length - 1;
        for (int i = 0; i <= tail; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[pre];
                nums[pre] = 0;
                pre++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[tail];
                nums[tail] = 2;
                tail--;
                //注意交换2之后，可能原位置变成0，需要重新挪一遍
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }
}

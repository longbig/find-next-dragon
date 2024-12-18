package leetcode2024.medium;

import java.util.Arrays;

/**
 * 287. 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LeetCode287 {

    /**
     * 解法二：问题转换为找环形链表中环的入口节点
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //相遇的位置不一定是入口，只能是环内
        //所以需要一个新的指针从链表头开始走x， 慢指针会和新指针在链表环的入口相遇
        int pre = 0;
        while (pre != slow) {
            pre = nums[pre];
            slow = nums[slow];
        }
        return pre;

    }

    /**
     * 解法一：排序+异或操作
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] ^ nums[i - 1];
            if (temp == 0) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        LeetCode287 leetCode287 = new LeetCode287();
        int[] nums = new int[]{3, 1, 3, 2};
        int data = leetCode287.findDuplicate(nums);
        System.out.println(data);
    }
}

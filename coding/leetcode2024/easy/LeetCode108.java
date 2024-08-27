package leetcode2024.easy;

import leetcode2021.TreeNode;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2024/8/17 16:32
 * @description 108. 将有序数组转换为二叉搜索树
 * 你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
 * 平衡
 *  二叉搜索树。
 */
public class LeetCode108 {

    /**
     * 递归解法，甜姨的解法
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;

    }
//
//    /**
//     * 解题思路：找中间节点，左右子数组 对应 子树
//     * 接着找子数组的中间节点，即为对应的左右子树的根节点
//     *
//     * @param nums
//     * @return
//     */
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        int mid = nums.length / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//
//        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
//        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
//
//        return root;
//    }

}

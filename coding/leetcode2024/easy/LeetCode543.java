package leetcode2024.easy;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2024/8/16 00:36
 * @description 二叉树的直径
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class LeetCode543 {

    private int max = 0;

    /**
     * 甜姨解法：遍历每个节点，以该节点为中心，计算该节点位置的最长路径，更新全局变量
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(leftSize + rightSize, max);
        return Math.max(leftSize, rightSize);
    }
}

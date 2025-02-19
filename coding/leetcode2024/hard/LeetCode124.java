package leetcode2024.hard;

import leetcode2021.TreeNode;

/**
 * 124 二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class LeetCode124 {

    /**
     * 解题思路参考评论区：
     * 不用看官方题解，那么复杂。 所有树的题目，都想成一颗只有根、左节点、右节点 的小树。然后一颗颗小树构成整棵大树，所以只需要考虑这颗小树即可。
     * 接下来分情况， 按照题意：一颗三个节点的小树的结果只可能有如下6种情况：
     *
     * 1 根 + 左 + 右
     * 2 根 + 左
     * 3 根 + 右
     * 4 根
     * 左
     * 右
     * 好了，分析上述6种情况， 只有 2,3,4 可以向上累加，而1,5,6不可以累加（这个很好想，情况1向上累加的话，必然出现分叉，
     * 情况5和6直接就跟上面的树枝断开的，没法累加），所以我们找一个全局变量存储 1,5,6这三种不可累加的最大值，
     * 另一方面咱们用遍历树的方法求2,3,4这三种可以累加的情况。 最后把两类情况得到的最大值再取一个最大值即可。
     */

    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果左右子树为负数，为了不取这条路径，可以设为0
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxPath = Math.max(maxPath, root.val + left + right);

        return root.val + Math.max(left, right);

    }
}

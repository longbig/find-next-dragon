package leetcode2024.easy;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2024/8/15 00:52
 * @description
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int maxDepthCurr = Math.max(maxDepth(root.left), maxDepth(root.right));
        return 1 + maxDepthCurr;

    }
}

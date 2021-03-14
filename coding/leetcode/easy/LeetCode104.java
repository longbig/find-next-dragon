package leetcode.easy;

import leetcode.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/3/13 10:31 下午
 * @description
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        return find(0, root);
    }

    private int find(int h, TreeNode root) {
        if (root == null) {
            return h;
        }
        h = h + 1;
        int leftH = find(h, root.left);
        int rightH = find(h, root.right);
        return Math.max(leftH, rightH);
    }
}

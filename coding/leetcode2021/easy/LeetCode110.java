package leetcode2021.easy;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/6/14 11:50 上午
 * @description 平衡二叉树
 */
public class LeetCode110 {

    /**
     * 优化解法：自底向上
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }


    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(height1(root.left) - height1(root.right)) <= 1)
                && isBalanced1(root.left) && isBalanced1(root.right);

    }

    private int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height1(root.left), height1(root.right)) + 1;

    }
}

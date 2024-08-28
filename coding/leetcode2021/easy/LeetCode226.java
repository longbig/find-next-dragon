package leetcode2021.easy;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/5/27 10:25 上午
 * @description
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        return reverse(root);
    }

    private TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
        return root;
    }
}

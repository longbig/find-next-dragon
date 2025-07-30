package leetcode2025;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:46
 * @description
 */
public class LeetCode226 {

    //递归方式
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

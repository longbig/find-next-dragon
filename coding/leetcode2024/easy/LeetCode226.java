package leetcode2024.easy;

import leetcode.TreeNode;

/**
 * @author yuyunlong
 * @date 2024/8/15 23:57
 * @description 镜像二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class LeetCode226 {

    /**
     * 递归方法解决
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;

    }
}

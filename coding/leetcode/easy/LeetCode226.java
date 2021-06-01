package leetcode.easy;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

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

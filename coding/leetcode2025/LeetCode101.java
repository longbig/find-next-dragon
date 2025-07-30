package leetcode2025;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:04
 * @description
 */
public class LeetCode101 {

    //递归方法判断
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSon(root.left, root.right);
    }

    private boolean checkSon(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //最后是两个都不为空的情况了
        return left.val == right.val && checkSon(left.left, right.right) && checkSon(left.right, right.left);
    }
}

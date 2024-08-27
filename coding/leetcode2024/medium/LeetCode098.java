package leetcode2024.medium;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2024/8/17 17:07
 * @description 验证二叉搜索树
 * 判断左右子节点的值是否符合二叉搜索树性质
 *有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LeetCode098 {
    /**
     * 官方解法，设置一个范围，每次递归时更新边界
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }
}

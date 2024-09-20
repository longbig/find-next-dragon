package leetcode2024.easy;

import leetcode2021.TreeNode;

/**
 * @author Administrator
 * @date 2024/9/20 9:29
 * @description 100. 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //前序遍历判断
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        boolean leftCheck = isSameTree(p.left, q.left);
        boolean rightCheck = isSameTree(p.right, q.right);
        return leftCheck && rightCheck;

    }
}

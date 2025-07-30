package leetcode2025;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2025/7/30 00:46
 * @description
 */
public class LeetCode100 {

    //递归思路求解，就把整棵树看作三个节点构成的就行
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null) || p.val != q.val) {
            return false;
        }
        boolean checkLeft = isSameTree(p.left, q.left);
        boolean checkRight = isSameTree(p.right, q.right);
        return checkRight && checkLeft;
    }
}

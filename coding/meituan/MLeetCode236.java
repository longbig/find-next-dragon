package meituan;

import leetcode.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/6/2 11:53 下午
 * @description 找二叉树的最近公共祖先结点
 */
public class MLeetCode236 {

    private TreeNode ans;

    private Boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        Boolean leftPQ = dfs(root.left, p, q);
        Boolean rightPQ = dfs(root.right, p, q);
        if ((leftPQ && rightPQ) ||
                (((root.val == p.val) || (root.val == q.val)) && (leftPQ || rightPQ))) {
            this.ans = root;
        }
        //判断是否包含p结点或者q结点
        return leftPQ || rightPQ || root.val == p.val || root.val == q.val;
    }

    //解题思路：递归的思路，f函数表示该结点是否包含p结点或q结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

package leetcode2025;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:35
 * @description
 */
public class LeetCode236 {

    //递归的方式，假设root的左右子树看做单个节点，就只需要判断这三个节点的关系就行
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }
        //p q 分散在两颗子树还是 聚合在一颗子树中
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }
        return root;
    }
}

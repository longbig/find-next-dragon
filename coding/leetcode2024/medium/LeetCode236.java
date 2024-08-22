package leetcode2024.medium;

import leetcode.TreeNode;

/**
 * @author Administrator
 * @date 2024/8/22 19:29
 * @description 236. 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LeetCode236 {



    //递归思路，遍历，找是否命中了其中一个节点，如果当前节点的左右子节点都有，说明当前节点就是最深的祖先节点了
    //反之，如果只有左子树上找到节点，右节点返回空，那么只找左子树就行。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode == null) {
            return rightNode;
        }
        return leftNode;
    }


}

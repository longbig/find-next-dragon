package leetcode.easy;

import leetcode.TreeNode;

/**
 * @author yuyunlong
 * @date 2022/10/3 10:21 下午
 * @description
 */
public class LeetCode572 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /**
     * 另一棵树的子树
     * 思路，遍历一棵树，如果遍历节点和另一个树节点一样，进行前、后序遍历，依次判断即可
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            //进行判断
            return false;
        }
        //遍历root的节点
        return reverse(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }

    //同时遍历
    private boolean reverse(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return reverse(root.left, subRoot.left) && reverse(root.right, subRoot.right);
    }
}

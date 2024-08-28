package leetcode2021.easy;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/6/1 6:46 下午
 * @description 合并二叉树
 */
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
        }
        if (root1 == null && root2 != null) {
            root1 = new TreeNode(root2.val);
        }

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    //官方方法
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }
}

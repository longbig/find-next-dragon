package leetcode2024.medium;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2024/8/19 9:25
 * @description 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode head = new TreeNode();
        for (TreeNode treeNode : list) {
            head.right = treeNode;
            head.left = null;
            head = head.right;
        }
        root = list.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left == null && root.right == null) {
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}

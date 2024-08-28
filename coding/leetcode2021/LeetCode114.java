package leetcode2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2020/8/2 5:37 下午
 * @description
 *
 * 给定一个二叉树，原地将它展开为一个单链表。按照前序遍历的方法
 */
public class LeetCode114 {

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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
    }

    /**
     * 前序遍历方法
     * @param head
     * @return
     */
    public void preOrder(TreeNode head, List<TreeNode> list) {
        if (head != null) {
            list.add(head);
            preOrder(head.left, list);
            preOrder(head.right, list);
        }
    }
}

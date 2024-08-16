package leetcode2024.easy;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @date 2024/8/14 18:38
 * @description 二叉树的中序遍历
 * 左根右
 */
public class LeetCode094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(new Node(root, false));
        while (stack.size() > 0) {
            Node node = stack.pop();
            if (node.visitFlag) {
                res.add(node.treeNode.val);
                continue;
            }
            if (root.right != null) {
                stack.push(new Node(root.right, false));
            }
            node.visitFlag = true;
            stack.push(node);
            if (root.left != null) {
                stack.push(new Node(root.left, false));
            }
        }
        return res;

    }

    class Node {
        TreeNode treeNode;
        boolean visitFlag;

        Node(TreeNode treeNode, boolean visitFlag) {
            this.treeNode = treeNode;
            this.visitFlag = visitFlag;
        }
    }
}

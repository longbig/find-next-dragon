package leetcode2021.easy;


import leetcode2021.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuyunlong
 * @date 2021/5/27 9:00 上午
 * @description
 */
public class LeetCode094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            root = temp.right;
        }
        return result;

    }
}

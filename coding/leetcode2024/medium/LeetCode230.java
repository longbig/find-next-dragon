package leetcode2024.medium;

import leetcode2021.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2024/8/17 19:52
 * @description 230. 二叉搜索树中第 K 小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class LeetCode230 {

    private int i = 0, ans = 0;
    /**
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        i++;
        if (i == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
        return;
    }


    //迭代的方法中序遍历二叉树
    public int kthSmallestForDiedai(TreeNode root, int k) {
        //迭代是通过一个栈
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == k) {
                break;
            }
            root = root.right;
        }
        return root.val;

    }
}

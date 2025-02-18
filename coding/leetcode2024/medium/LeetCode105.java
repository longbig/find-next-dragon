package leetcode2024.medium;

import leetcode2021.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class LeetCode105 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 递归思路解决问题
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = preorder.length;
        TreeNode result = handle(preorder, inorder, 0, n - 1, 0, n -1);
        return result;
    }

    private TreeNode handle(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end) {
            return null;
        }
        //构造根节点，前序遍历第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[pre_start]);
        //现在需要递归构造左右子树就行
        int in_index = indexMap.get(preorder[pre_start]);
        int size_left_len = in_index - in_start;

        root.left = handle(preorder, inorder, pre_start + 1, pre_start + size_left_len, in_start, in_index - 1);
        root.right = handle(preorder, inorder, pre_start + size_left_len + 1, pre_end, in_index + 1, in_end);
        return root;
    }
}

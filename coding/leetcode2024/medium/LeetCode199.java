package leetcode2024.medium;

import leetcode2021.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2024/8/18 00:05
 * @description 199. 二叉树的右视图
 *
 */
public class LeetCode199 {


    /**
     * 解题思路：层次遍历，取最后一个元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode temp = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            list.add(temp.val);
        }

        return list;
    }

}

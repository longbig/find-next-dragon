package leetcode2024.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode2021.TreeNode;


/**
 * @author Administrator
 * @date 2024/8/16 16:05
 * @description 二叉树的层次遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode102 {

    /**
     * 借助队列实现层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //限制长度取数就行，不需要额外空间了
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(list);

        }
        return result;

    }
}

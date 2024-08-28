package leetcode2021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyunlong
 * @date 2020/8/21 8:39 下午
 * @description 二叉树的最小深度
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //广度优先搜索方法
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return wfs(queue);
    }

    private int wfs(Queue<TreeNode> queue) {
        int count = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.left == null && node.right == null) {
                return count;
            }
            queue.offer(node.left);
            queue.offer(node.right);
            count++;
        }

        return count;
    }
}

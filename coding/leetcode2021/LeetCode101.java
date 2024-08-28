package leetcode2021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyunlong
 * @date 2021/2/10 9:49 下午
 * @description
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        TreeNode q = root;
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();

            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || u.val != v.val) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

}

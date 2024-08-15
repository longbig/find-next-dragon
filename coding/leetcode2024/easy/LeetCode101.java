package leetcode2024.easy;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2024/8/16 00:06
 * @description 判断是否对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LeetCode101 {

    /**
     * 老规矩，递归方法解决,其实是判断根节点的左右子树是否对称。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judgeForDigui(root.left, root.right);

    }

    /**
     * 迭代的方法，借助一个队列实现，每次入队列两个元素，比较值后，
     * 然后入 左.left, 右.right ...
     * @param L
     * @param R
     * @return
     */
    private boolean judgeForDigui(TreeNode L, TreeNode R) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(L);
        queue.offer(R);
        while (!queue.isEmpty()) {
            TreeNode l1 = queue.poll();
            TreeNode r1 = queue.poll();
            if (l1 == null && r1 == null) {
                continue;
            }
            if (l1 == null || r1 == null || l1.val != r1.val) {
                return false;
            }
            queue.offer(l1.left);
            queue.offer(r1.right);
            queue.offer(l1.right);
            queue.offer(r1.left);
        }
        return true;
    }

    private boolean judge(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return L.val == R.val && judge(L.left, R.right) && judge(L.right, R.left);
    }
}

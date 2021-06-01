package quiz;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuyunlong
 * @date 2021/5/10 9:24 上午
 * @description 之字形打印二叉树
 */
public class Niuke01 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot != null) {
            queue.add(pRoot);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    tmp.add(node.val);
                } else {
                    tmp.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

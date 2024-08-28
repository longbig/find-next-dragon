package leetcode2021.medium;

import leetcode2021.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2021/6/26 5:16 下午
 * @description
 */
public class LeetCode662 {

    private int ans = 0;
    private Map<Integer, Integer> map;

    /**
     * 深度优先遍历的思路，用left[depth]记录每层最左边的结点的position值
     */
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        int depth = 0, pos = 0;
        int res = dfs(root, depth, pos);
        return res;
    }

    private int dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return 0;
        }
        if (map.get(depth) == null) {
            map.put(depth, pos);
        }
        ans = Math.max(ans, pos - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
        return ans;
    }
}

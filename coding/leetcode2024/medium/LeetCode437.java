package leetcode2024.medium;

import leetcode2021.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 */
public class LeetCode437 {

    private int ans;

    /**
     * 解法参考LeetCode560，前缀和+两数之和的解法，这个是针对二叉树写的，需要用到深度优先遍历
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> countMap = new HashMap<>();
        //key为路径和，value为出现次数
        countMap.put(0L, 1);
        long currentSum = 0L;
        dfs(root, countMap, currentSum, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, Map<Long, Integer> countMap, long currentSum, int targetSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (countMap.containsKey(currentSum - targetSum)) {
            ans += countMap.get(currentSum - targetSum);
        }
        Integer cs = countMap.get(currentSum);
        cs = cs == null ? 0 : cs;
        countMap.put(currentSum, cs + 1);

        dfs(root.left, countMap, currentSum, targetSum);
        dfs(root.right, countMap, currentSum, targetSum);
        //递归完，注意恢复现场
        countMap.put(currentSum, countMap.get(currentSum) - 1);
    }


}

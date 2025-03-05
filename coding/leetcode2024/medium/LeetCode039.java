package leetcode2024.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class LeetCode039 {

    /**
     * 直接套用回溯法的模板，区别在于终止条件由深度变为目标值为0 的情况了
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int index = 0;
        backtrace(candidates, target, index, result, current);
        return result;

    }

    private void backtrace(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            current.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i, result, current);
            current.remove(current.size() - 1);
        }

    }
}

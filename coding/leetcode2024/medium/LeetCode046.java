package leetcode2024.medium;

import java.util.*;


public class LeetCode046 {

    /**
     * 全排列，需要用到回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            output.add(nums[i]);
        }
        int n = nums.length;
        handle(result, output, n, 0);
        return result;

    }

    private void handle(List<List<Integer>> result, List<Integer> output, int n, int first) {
        if (first == n) {
            result.add(new ArrayList<>(output));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            handle(result, output, n, first + 1);
            Collections.swap(output, i, first);
        }

    }
}

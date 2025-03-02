package leetcode2024.medium;

import java.util.*;

/**
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode046 {

    public static void main(String[] args) {
        LeetCode046 leetCode046 = new LeetCode046();
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = leetCode046.permute(nums);
        for (List<Integer> list : result) {
            for (Integer in : list) {
                System.out.print(in + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        //做回溯算法
        int depth = 0;
        Deque<Integer> currentArray = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, depth, currentArray, visited, result);
        return result;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> currentArray, boolean[] visited,
                     List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(currentArray));
            return;
        }
        //深度搜索
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                currentArray.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1, currentArray, visited, result);
                visited[i] = false;
                currentArray.removeLast();
            }
        }
    }


//    /**
//     * 全排列，需要用到回溯法
//     * @param nums
//     * @return
//     */
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return result;
//        }
//
//        List<Integer> output = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            output.add(nums[i]);
//        }
//        int n = nums.length;
//        handle(result, output, n, 0);
//        return result;
//
//    }
//
//    private void handle(List<List<Integer>> result, List<Integer> output, int n, int first) {
//        if (first == n) {
//            result.add(new ArrayList<>(output));
//        }
//
//        for (int i = first; i < n; i++) {
//            Collections.swap(output, first, i);
//            handle(result, output, n, first + 1);
//            Collections.swap(output, i, first);
//        }
//
//    }
}

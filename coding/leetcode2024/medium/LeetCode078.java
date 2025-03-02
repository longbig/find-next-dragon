package leetcode2024.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 不重复的子集
 */
public class LeetCode078 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        LeetCode078 test = new LeetCode078();
        List<List<Integer>> result = test.subsets(nums);
        for (List<Integer> list : result) {
            for (Integer in : list) {
                System.out.print(in + ",");
            }
            System.out.println();
        }
    }


    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> queue = new ArrayList<>();
    /**
     * 还是回溯法，比全排列简单些，深度遍历时，不需要判断是否到达最大深度
     */
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>(queue));
        dfs(nums, 0,  queue);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> queue) {
        for (int i = start; i < nums.length; i++) {
            queue.add(nums[i]);
            result.add(new ArrayList<>(queue));
            //这一步注意是i + 1，不要写成start + 1，在这里卡了一次
            dfs(nums, i + 1, queue);
            queue.remove(queue.size() - 1);
        }
    }
}

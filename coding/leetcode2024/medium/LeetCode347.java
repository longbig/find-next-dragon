package leetcode2024.medium;

import java.util.*;

/**
 * @author Administrator
 * @date 2024/8/30 8:58
 * @description 347. 前 K 个高频元素
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                }
                return -1;
            }
        });
        Map<Integer, Integer> countMap = new HashMap<>();
        //遍历数组，放入堆中
        for (int i = 0; i < nums.length; i++) {
            Integer curr = countMap.get(nums[i]);
            if (curr == null) {
                curr = 1;
            } else {
                curr += 1;
            }
            countMap.put(nums[i], curr);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : countMap.entrySet()) {
            int[] subNode = new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()};
            priorityQueue.offer(subNode);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int[] node = priorityQueue.poll();
            result[i] = node[0];
        }
        return result;

    }
}

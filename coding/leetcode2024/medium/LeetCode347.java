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

    //解法：用hashmap计算元素出现的次数，接着使用优先队列，按频率取前K个元素
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = countMap.getOrDefault(nums[i], 0);
            countMap.put(nums[i], ++c);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            pQueue.offer(new int[]{key, count});
        }

        //取key个数
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pQueue.poll()[0];
        }
        return result;

    }
}

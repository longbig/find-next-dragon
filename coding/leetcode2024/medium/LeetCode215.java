package leetcode2024.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @date 2024/8/29 9:12
 * @description 215. 数组中的第K个最大元素
 */
public class LeetCode215 {

    //大顶堆解决
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                }
                return 1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        Integer num = null;
        for (int i = k; i > 0; i--) {
            num = priorityQueue.poll();
        }
        return num;

    }
}

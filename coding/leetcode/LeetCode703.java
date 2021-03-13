package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yuyunlong
 * @date 2021/2/11 10:43 上午
 * @description
 */
public class LeetCode703 {
    
    private int k;
    private PriorityQueue<Integer> queue;

    public LeetCode703(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

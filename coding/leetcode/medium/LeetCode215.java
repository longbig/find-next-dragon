package leetcode.medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author yuyunlong
 * @date 2021/4/24 12:29 下午
 * @description 数组的第k大元素
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        LeetCode215 test = new LeetCode215();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(test.findKthLargest(nums, 2));
    }
}

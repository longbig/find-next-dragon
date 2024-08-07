package leetcode2024.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Administrator
 * @date 2024/8/7 8:55
 * @description 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class LeetCode239 {

    /**
     * 思路：用最大堆存储窗口里的数组，堆顶元素一定是最大的，并且存储他们的下标，
     * 滑动时，判断最大值的下标是否已退出滑动窗口
     * 如果退出，则将堆顶元素弹出，直到新的堆顶元素在滑动窗口内
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //如果两个相等，应该先弹出左边的那个
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            maxQueue.offer(new int[]{nums[i], i});
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = maxQueue.peek()[0];//right多走了一步

        for (int i = k; i < nums.length; i++) {

            maxQueue.offer(new int[]{nums[i], i});
            //只需要判断堆顶元素是否不在窗口内
            int leftIndex = maxQueue.peek()[1];
            while (leftIndex < (i - k + 1)) {
                maxQueue.poll();
                leftIndex = maxQueue.peek()[1];
            }
            result[i - k + 1] = maxQueue.peek()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] array = leetCode239.maxSlidingWindow(nums, k);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

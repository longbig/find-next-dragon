package leetcode2024.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2024/8/4 14:17
 * @description 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LeetCode128 {

    /**
     * 解决思路：用集合去重，然后每个元素判断他是不是序列开始的第一个元素，即判断集合中有没有 x-1 的值，如果是开始，
     * 循环判断 x+1是否存在，得到最长的值
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1, x = num;
            while (set.contains(x + 1)) {
                len++;
                x = x + 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

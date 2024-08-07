package leetcode2024.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2024/8/6 23:39
 * @description 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 */
public class LeetCode560 {

    /**
     * 思路：用前缀和以及 两数之和的思路求解
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        //子数组 i,j  可以理解为 0,j  -  0,i 前缀和之差，这样降级为两个数的差值为k
        //前缀和，次数
        prefixMap.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixMap.containsKey(sum - k)) {
                count += prefixMap.get(sum - k);
            }
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

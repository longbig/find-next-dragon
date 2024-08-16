package leetcode2024.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2024/8/16 9:23
 * @description 多数元素
 *
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class LeetCode169 {

    /**
     * 用哈希表解决
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = hashMap.getOrDefault(nums[i], 0) + 1;
            if (count > (n / 2)) {
                return nums[i];
            }
            hashMap.put(nums[i], count);
        }
        return 0;
    }
}

package leetcode2024.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2024/9/22 15:14
 * @description 219. 存在重复元素 II
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class LeetCode219 {

    //哈希表解决
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(nums[i])) {
                int j = valueIndexMap.get(nums[i]);
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            valueIndexMap.put(nums[i], i);
        }
        return false;
    }
}

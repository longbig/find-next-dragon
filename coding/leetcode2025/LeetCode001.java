package leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2025/7/26 13:34
 * @description
 */
public class LeetCode001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}

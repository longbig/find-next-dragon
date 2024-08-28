package leetcode2021;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2020/12/21 1:13 下午
 * @description 两数之和
 */
public class LeetCode001 {

    public int[] TwoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[0];
    }
}

package leetcode2021.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2021/3/14 11:25 下午
 * @description https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/572x9r/
 */
public class LeetCode000 {

    public boolean isStraight(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int max = 0, min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (hashSet.contains(nums[i])) {
                return false;
            }
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            hashSet.add(nums[i]);
        }
        if (max - min >= 5) {
            return false;
        }
        return true;

    }
}

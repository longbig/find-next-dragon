package leetcode2021.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2021/6/15 4:36 下午
 * @description 两数之和II
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, Integer> hashMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            hashMap.put(numbers[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                result[0] = i + 1;
                result[1] = hashMap.get(target - numbers[i]) + 1;
                break;
            }

        }
        return result;
    }

    //双指针法
    public int[] twoSum1(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                ++left;
            } else {
                --right;
            }
        }
        return new int[]{-1, -1};
    }
}

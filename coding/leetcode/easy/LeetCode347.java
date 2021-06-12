package leetcode.easy;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2021/6/9 11:40 下午
 * @description 前K个高频元素
 */
public class LeetCode347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer value = hashMap.get(key);
            if (value != null) {
                value++;
                hashMap.put(key, value);
            } else {
                hashMap.put(key, 1);
            }
        }

        for (int i = k; i > 0; i--) {
            int max = 0, key = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
                if (integerIntegerEntry.getValue() > max) {
                    key = integerIntegerEntry.getKey();
                    max = integerIntegerEntry.getValue();
                }
            }
            list.add(key);
            hashMap.remove(key);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}

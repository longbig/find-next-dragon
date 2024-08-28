package leetcode2021.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2021/6/20 3:25 下午
 * @description 两个数组求交集
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] result = new int[set2.size()];
        int n = 0;
        for (Integer val : set2) {
            result[n++] = val;
        }
        return result;
    }
}

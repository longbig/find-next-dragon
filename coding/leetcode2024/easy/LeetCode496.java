package leetcode2024.easy;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2024/8/27 23:30
 * @description 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            nums2Map.put(nums2[i], -1);
        }

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                Integer preIndex = stack.pop();
                nums2Map.put(nums2[preIndex], nums2[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums2Map.get(nums1[i]);
        }
        return nums1;

    }
}

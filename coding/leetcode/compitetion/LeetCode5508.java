package leetcode.compitetion;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2020/9/6 11:11 上午
 * @description
 */
public class LeetCode5508 {
    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
     *
     * 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
     * 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
     * @param nums1
     * @param nums2
     * @return
     */
    public int numTriplets(int[] nums1, int[] nums2) {
        //解题思路：1.找相等的；2.如果没有，用大的数做除法，能整除才有可能成立
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum = 0;

        sum = compute(nums1, nums2, sum);
        sum = compute(nums2, nums1, sum);
        return sum;
    }

    private int compute(int[] nums1, int[] nums2, int sum) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //相同情况
                if (nums1[i] == nums2[j]) {
                    for (int m = j + 1; m < nums2.length; m++) {
                        if (nums1[i] == nums2[m]) {
                            sum++;
                        }
                    }
                }
                //大于
                if (nums1[i] < nums2[j]) {
                    if (nums2[j] % nums1[i] == 0) {
                        int little = nums2[j] / nums1[i];
                        if (nums1[i] % little == 0) {
                            int lit2 = nums1[i] / little;
                            for (int k = 0; k < nums2.length; k++) {
                                if (nums2[k] == lit2) {
                                    sum++;
                                }
                            }
                        }

                    }
                }
            }
        }
        return sum;
    }
}

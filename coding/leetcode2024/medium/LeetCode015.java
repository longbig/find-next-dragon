package leetcode2024.medium;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2024/8/5 21:18
 * @description 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class LeetCode015 {

    /**
     * 三指针操作
     * 注意可以先将数组排序，排序后从小到大。
     * 指针k，i，j
     * k指向数组，从左到右遍历，且需要跳过重复的元素
     * i，j 指向的k右边的数组的左右两端
     * 移动逻辑：k指向时不动，只动i，j，三者相加大于0，说明j需要往左移
     * 三者相加小于0，说明i需要往右移
     * 注意：如果k指向的数字大于0，可以退出循环了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            //k往前移动时，重复的跳过
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    //此时两指针可能还能移动
                    while (i < j && nums[j] == nums[--j]);
                    while (i < j && nums[i] == nums[i++]);
                }
            }

        }
        return list;

    }


}

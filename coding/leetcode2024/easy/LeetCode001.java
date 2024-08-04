package leetcode2024.easy;

import java.util.HashMap;

/**
 * @author yuyunlong
 * @date 2024/8/4 13:27
 * @description 两数之和，给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
public class LeetCode001 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //插入之前，先找下是否存在target - x 的值，有的话直接返回i 和 另一个下标
            if (tempMap.containsKey(target - nums[i])) {
                return new int[]{tempMap.get(target - nums[i]), i};
            }
            tempMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode001 leetCode001 = new LeetCode001();
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] array = leetCode001.twoSum(nums, target);
        for (int i : array) {
            System.out.println(i);
        }
    }
}

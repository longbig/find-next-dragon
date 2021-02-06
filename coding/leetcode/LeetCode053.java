package leetcode;

/**
 * @author yuyunlong
 * @date 2021/1/30 4:28 下午
 * @description
 */
public class LeetCode053 {
    /**
     * 存在一个关系 f(n) = max(f(n-1) + nums[n], nums[n])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int f_n = 0, maxAns = nums[0];
        for (int num : nums) {
            f_n = Math.max(f_n + num, num);
            maxAns = Math.max(f_n, maxAns);
        }
        return maxAns;
    }
}

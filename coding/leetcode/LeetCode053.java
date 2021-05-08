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
        int res = nums[0], pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }
        return res;
    }
}

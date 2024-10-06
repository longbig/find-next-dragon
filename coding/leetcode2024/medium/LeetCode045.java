package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/10/5 11:39
 * @description 45. 跳跃游戏 II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，
 * 如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class LeetCode045 {

    //每次以范围看作一个点，每次跳跃计算范围，范围超过数组时即到达，记录跳跃次数
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int step = 0, end = 0, maxLen = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (i == end) {
                step++;
                end = maxLen;
            }
        }
        return step;
    }
}

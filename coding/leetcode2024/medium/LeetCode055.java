package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/10/5 11:20
 * @description 55. 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode055 {

    //遍历数组，判断每个元素的位置是否可达，不可达返回false就行
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int jumpLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (jumpLen < i) {
                return false;
            }
            jumpLen = Math.max(jumpLen, i + nums[i]);
        }
        return true;
    }
}

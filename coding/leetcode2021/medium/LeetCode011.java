package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/3/20 7:32 下午
 * @description 双指针法
 */
public class LeetCode011 {

    public int maxArea(int[] height) {
        int maxV = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxV = Math.max(maxV, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxV;
    }
}

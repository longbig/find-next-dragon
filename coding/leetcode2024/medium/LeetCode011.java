package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/8/5 21:06
 * @description 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class LeetCode011 {

    /**
     * 思路：双指针法，指向头和尾，每次移动数字小的那个指针，
     * 为什么移动小的那个，因为移动后长度会变小，而高度如果一直是小的那个的话，面积只会越来越小
     *
     *装多少水是由最短边决定的，为什么最短边移动，是因为如果长边移动，那么装的水可能会少，
     * （因为由最短边决定，无论你长边移动后高度增加或者减少，都只能是装水量变少。）不可能会多。
     * 而如果移动最短边，那么有可能能够装更多的水。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int indexLeft = 0, indexRight = height.length - 1, maxArea = 0;
        while (indexLeft < indexRight) {
            int leftNum = height[indexLeft];
            int rightNum = height[indexRight];
            int h = Math.min(leftNum, rightNum);
            int area = (indexRight - indexLeft) * h;
            maxArea = Math.max(maxArea, area);
            //移动了
            if (leftNum < rightNum) {
                indexLeft++;
            } else {
                indexRight--;
            }

        }
        return maxArea;
    }
}

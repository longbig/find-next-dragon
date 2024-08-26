package leetcode2024.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2024/8/26 18:46
 * @description 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *方法二：单调栈求解 以上暴力写法 Java 可以通过，但我们不妨想一下这里的双重循环是否可以优化？
 *
 * 我们每遍历到当前柱体 i 时：
 *
 * 上述写法中，我们需要再嵌套一层 while 循环来向左找到第一个比柱体 i 高度小的柱体，这个过程是 O(N) 的；
 * 那么我们可以 O(1) 的获取柱体 i 左边第一个比它小的柱体吗？答案就是单调增栈，
 * 因为对于栈中的柱体来说，栈中下一个柱体就是左边第一个高度小于自身的柱体。
 */
public class Leetcode084 {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < stack.peek()) {
                //遇到第一个小的数，开始计算当前位置能得到的最大面积
                int index = stack.pop();
                int h = temp[index];
                maxArea = Math.max(maxArea, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

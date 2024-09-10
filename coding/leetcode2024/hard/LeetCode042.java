package leetcode2024.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2024/9/10 23:30
 * @description 接雨水
 */
public class LeetCode042 {

    //官方，单调栈解法
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        //单调递减栈
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int currIndex = stack.pop();
                //注意如果有相同高度，直接一起出栈
                while (!stack.isEmpty() && height[stack.peek()] == height[currIndex]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    int currLeft = stack.peek();
                    int h = Math.min(height[i], height[currLeft]) - height[currIndex];
                    int width = i - currLeft - 1;
                    ans += (h * width);
                }

            }
            stack.push(i);
        }
        return ans;
    }
}

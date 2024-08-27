package leetcode2024.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2024/8/27 8:56
 * @description 每日温度
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        //单调递增栈
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode739 leetCode739 = new LeetCode739();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] result = leetCode739.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

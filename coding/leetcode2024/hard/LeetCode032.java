package leetcode2024.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最长的有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 */
public class LeetCode032 {

    public static void main(String[] args) {
        LeetCode032 test = new LeetCode032();
        String s = "(()";
        int result = test.longestValidParentheses(s);
        System.out.println(result);
    }

    /**
     * 评论区大佬的方法：
     * 用栈模拟一遍，将所有无法匹配的括号的位置全部置1
     * 例如: "()(()"的mark为[0, 0, 1, 0, 0]
     * 再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
     * 经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //准备一个栈，只存左括号
        Deque<Integer> stack = new LinkedList<>();
        int[] array = new int[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('(' == ch) {
                stack.push(i);
            } else {
                //遇到右括号，这时左括号应该出栈，如果没有，则标记1
                if (stack.isEmpty()) {
                    array[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        //未匹配的左括号标记1
        while (!stack.isEmpty()) {
            array[stack.pop()] = 1;
        }
        //找最长的连续0子列
        int maxLen = 0, len = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                len = 0;
                continue;
            }
            len++;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

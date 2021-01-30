package leetcode;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2021/1/9 11:40 上午
 * @description
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
               stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || !stack.pop().equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}

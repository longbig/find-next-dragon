package leetcode2024.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2024/8/18 20:20
 * @description 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class LeetCode020 {

    /**
     * 解题思路：用一个栈解决
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
                continue;
            }

            if (array[i] == ')') {
                char temp = stack.pop();
                if (temp != '(') {
                    return false;
                }
            } else if (array[i] == ']') {
                char temp = stack.pop();
                if (temp != '[') {
                    return false;
                }
            } else if (array[i] == '}') {
                char temp = stack.pop();
                if (temp != '{') {
                    return false;
                }
            } else {
                stack.push(array[i]);
            }

        }
        return stack.isEmpty();
    }
}

package leetcode2025;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2025/7/27 20:58
 * @description
 */
public class LeetCode020 {

    //用栈解决
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (map.containsKey(ch)) {
                if (stack.pop() == map.get(ch)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

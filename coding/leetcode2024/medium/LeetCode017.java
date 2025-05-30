package leetcode2024.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode017 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap =  new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        int index = 0;
        StringBuffer current = new StringBuffer();
        backtrace(digits, index, current, result, phoneMap);
        return result;
    }

    private void backtrace(String digits, int index, StringBuffer current, List<String> result, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            result.add(new String(current));
            return;
        }
        char ch = digits.charAt(index);
        String letters = phoneMap.get(ch);
        int letterCount = letters.length();
        for (int i = 0; i < letterCount; i++) {
            char temp = letters.charAt(i);
            current.append(temp);
            backtrace(digits, index + 1, current, result, phoneMap);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

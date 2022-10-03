package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/30 11:15 下午
 * @description 括号生成
 */
public class LeetCode022 {

    /**
     * 暴力法
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] array = new char[2 * n];
        generateAll(array, 0, result);
        return result;
    }

    private void generateAll(char[] array, int pos, List<String> result) {
        if (pos == array.length) {
            if (valid(array)) {
                result.add(new String(array));
            }
            return;
        }

        array[pos] = '(';
        generateAll(array, pos + 1, result);
        array[pos] = ')';
        generateAll(array, pos + 1, result);
    }

    private boolean valid(char[] array) {
        int balance = 0;
        for (char c : array) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}

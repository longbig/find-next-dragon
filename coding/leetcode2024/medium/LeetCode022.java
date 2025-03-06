package leetcode2024.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022 {

    public static void main(String[] args) {
        LeetCode022 test = new LeetCode022();
        List<String> result = test.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }

    }

    /**
     * 仍然使用回溯方法解决
     *
     * 终止条件是字符串长度为2n
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        backtrack("", n, result, 0, 0);
        return result;
    }

    private void backtrack(String current, int n, List<String> result, int leftUsed, int rightUsed) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (leftUsed < n) {
            backtrack(current + "(", n, result, leftUsed + 1, rightUsed);
        }
        if (rightUsed < leftUsed) {
            backtrack(current + ")", n, result, leftUsed, rightUsed + 1);
        }
    }
}

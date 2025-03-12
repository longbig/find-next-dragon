package leetcode2024.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
public class LeetCode131 {

    /**
     * 回溯法
     *
     * 从i开始到j位置[i, j]，为回文串则加入到path中，继续递归dfs(j + 1)，知道递归到i == s.length() 的位置，
     * 递归结束。
     *
     * 判断是否回文串，用双指针法，从两头开始比较，直到两指针相交
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int index = 0;
        dfs(s, result, index, path);
        return result;
    }

    private void dfs(String s, List<List<String>> result, int index, List<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isCheck(index, i, s)) {
                path.add(s.substring(index, i + 1));
                dfs(s, result, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isCheck(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

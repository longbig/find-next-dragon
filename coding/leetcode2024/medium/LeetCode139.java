package leetcode2024.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139 单词拆分
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LeetCode139 {

    /**
     * 动态规划的解法
     *
     * 比如字符串s的 第i位置是否合法， 设置j 在[0, i-1]区间内，j表示切割前面那段字符串的位置
     * 判断dp[i]是否合法，只需要判断dp[i] = dp[j] && check(s, j, i -1)，因为dp[j]的值已经知道了，主要判断后面那段是否存在单词能匹配就行
     * 匹配终止的条件是j到i - 1的长度已经大于字典里最长的字符串
     * 判断字符串是否存在，可以用哈希表
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>();
        for (String string : wordDict) {
            dictSet.add(string);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

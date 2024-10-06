package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/10/5 21:34
 * @description 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的
 * 回文
 *
 * 子串
 * 。
 */
public class LeetCode005 {

    //把字符串反转，求两个字符串的最长公共子串问题
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String reverse = new StringBuffer(s).reverse().toString();
        int m = s.length(), n = reverse.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        int maxLen = 0, indexEnd = 0;
        for (int i = 1; i <= m; i++) {
            char ch1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = reverse.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > maxLen) {
                    //判断是否是回文串，只需要判断下标能否满足转移方程
                    int beforeIndex = n - j;
                    if (beforeIndex + dp[i][j] == i) {
                        maxLen = dp[i][j];
                        indexEnd = i;
                    }
                }
            }
        }

        int indexStart = indexEnd - maxLen + 1;
        return s.substring(indexStart - 1, indexEnd);


    }
}

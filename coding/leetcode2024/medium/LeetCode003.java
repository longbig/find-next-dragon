package leetcode2024.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @date 2024/8/6 19:11
 * @description 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LeetCode003 {

    /**
     * 滑动窗口解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //定义2个指针
        int left = 0, right =  0, maxLength = 0;
        char[] charsArray = s.toCharArray();
        Set<Character> hashSet = new HashSet<>();
        while (right < s.length()) {

            if (hashSet.contains(charsArray[right])) {
                hashSet.remove(charsArray[left]);
                left++;
            } else {
                hashSet.add(charsArray[right]);
                maxLength = Math.max(hashSet.size(), maxLength);
                right++;
            }

        }
        return maxLength;

    }

}

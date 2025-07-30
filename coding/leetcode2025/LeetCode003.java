package leetcode2025;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:24
 * @description
 */
public class LeetCode003 {

    //滑动窗口解法
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, left = 0, right = 0;
        Set<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();

        while (right < s.length() && left <= right) {
            if (hashSet.contains(chars[right])) {
                hashSet.remove(chars[left]);
                left++;
            } else {
                hashSet.add(chars[right]);
                right++;
                max = Math.max(hashSet.size(), max);
            }
        }
        return max;
    }
}

package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2020/12/22 12:48 下午
 * @description
 */
public class LeetCode003 {

    public int findLongestSub(String s) {
        Set<Character> hashSet = new HashSet<>();
        int left = 0, right = -1;
        int ans = 0;
        while (left < s.length() && right < s.length()) {
            while ((right + 1) < s.length() && !hashSet.contains(s.charAt(right + 1))) {
                hashSet.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, (right - left + 1));

            if (left < s.length()) {
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}

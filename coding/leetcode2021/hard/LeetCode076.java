package leetcode2021.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2021/7/6 10:56 上午
 * @description 最小覆盖子串
 */
public class LeetCode076 {
    //官方解法已经很详细了
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int tlen = t.length(), slen = s.length();
        int ansL = -1, ansR = -1;
        int left = 0, right = -1, len = Integer.MAX_VALUE;
        //t所有字符放到tMap里
        for (int i = 0; i < tlen; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < slen) {
            right++;
            if (right < slen && tMap.containsKey(s.charAt(right))) {
                char ch = s.charAt(right);
                //sMap用于计数
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            }
            //满足条件时，再看看左边能不能收缩
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                //left收缩时，注意有元素退出，需要计数-1
                if (tMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        return ansL < 0 ? "" : s.substring(ansL, ansR);
    }

    //判断当前计数 和 tMap里的计数是否一样，或者满足了
    //将tMap遍历一遍，判断sMap里是否有元素，以及计数是否满足
    private boolean check() {
        Iterator iterator = tMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

}

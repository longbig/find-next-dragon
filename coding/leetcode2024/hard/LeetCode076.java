package leetcode2024.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2025/2/17 23:47
 * @description 76. 最小覆盖子串
 */
public class LeetCode076 {

    public static void main(String[] args) {
        LeetCode076 test = new LeetCode076();
        String s = "ADOBECODEBANCECBA", t = "ABC";
        String output = test.minWindow(s, t);
        System.out.println(output);
    }

    //根据题目提示，用两个指针的滑动窗口解法做，s中只有唯一子串
    public String minWindow(String s, String t) {
        char[] arrayT = t.toCharArray();
        Map<Character, Integer> tCharCountMap = new HashMap<>();
        Map<Character, Integer> currentCountMap = new HashMap<>();
        for (char c : arrayT) {
            int num = tCharCountMap.getOrDefault(c, 0);
            tCharCountMap.put(c, ++num);
        }

        int left = 0, right = -1;
        int ansLeft = -1, ansRight = -1, minLen = Integer.MAX_VALUE, ansRightTemp = -1;
        while (right < s.length()) {
            ++right;
            if (right < s.length() && tCharCountMap.containsKey(s.charAt(right))) {
                Integer currentNum = currentCountMap.get(s.charAt(right));
                currentNum = currentNum == null ? 0 : currentNum;
                currentCountMap.put(s.charAt(right), currentNum + 1);
            }
            //判断是否包含了全部字符，如果包含了，需要移动左指针
            while (check(tCharCountMap, currentCountMap) && left <= right) {
                //注意需要记录最短的
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansLeft = left;
                    ansRight = right;

                }
                //注意需要减一操作
                if (currentCountMap.containsKey(s.charAt(left))) {
                    currentCountMap.put(s.charAt(left), currentCountMap.get(s.charAt(left)) - 1);
                }
                ++left;
            }
        }
        //返回结果
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    private boolean check(Map<Character, Integer> tCharCountMap, Map<Character, Integer> currentCountMap) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : tCharCountMap.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer val = characterIntegerEntry.getValue();
            Integer currentKey = currentCountMap.get(key);
            currentKey = currentKey == null ? 0 : currentKey;
            if (currentKey < val) {
                return false;
            }
        }
        return true;
    }
}

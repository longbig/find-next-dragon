package leetcode2024.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2024/8/6 19:33
 * @description 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class LeetCode438 {

    /**
     * 滑动窗口解法，判断是不是异位词，先排序，再比较
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int left = 0, right = p.length() - 1;
        char[] arrayP = p.toCharArray();
        Arrays.sort(arrayP);
        String newP = new String(arrayP);

        while (right < s.length()) {
            String subS = s.substring(left, right + 1);
            //判断是否一致
            char[] arrayS = subS.toCharArray();
            Arrays.sort(arrayS);
            String newS = new String(arrayS);
            if (newS.equals(newP)) {
                list.add(left);
            }
            right++;
            left++;

        }
        return list;


    }
}

package leetcode2024.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2024/10/5 12:11
 * @description 763. 划分字母区间
 */
public class LeetCode763 {

    //解题：记录每个字母最后一次出现的位置就行,然后遍历时，需要统计子字符串中最远的位置，当i == 最远位置时就是切分的位置
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        for (int i = 0; i < s.length(); i++) {
            posMap.put(s.charAt(i), i);
        }

        int index = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, posMap.get(s.charAt(i)));
            if (i == end) {
                result.add(end - index + 1);
                index = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode763 leetCode763 = new LeetCode763();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = leetCode763.partitionLabels(s);
        System.out.println(result);
    }
}

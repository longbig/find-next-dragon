package leetcode2024.medium;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2024/8/4 13:47
 * @description 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 就是找出由相同字母组成的单词，每种子母的个数也相同。
 * ["nat","tan"]都由a t n这三个字母组成，["ate","eat","tea"]都由a e t这三个字母组成
 */
public class LeetCode049 {

    /**
     * 自己的方法，对字符串按字母顺序排序，排序后的作为Map的key， value是能转成对应key的原字符串数组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            String newStr = sortString(str);
            if (Objects.isNull(hashMap.get(newStr))) {
                List<String> strsList = new ArrayList<>();
                strsList.add(str);
                hashMap.put(newStr, strsList);
            } else {
                hashMap.get(newStr).add(str);
            }
        }

        return new ArrayList<List<String>>(hashMap.values());
    }

    /**
     * 按字母顺序排序，得到新字符串
     * @return
     */
    private String sortString(String strs) {
        char[] arrayChars = strs.toCharArray();
        Arrays.sort(arrayChars);
        return new String(arrayChars);
    }

    public static void main(String[] args) {
        LeetCode049 leetCode049 = new LeetCode049();
        String strs = "";
        System.out.println(leetCode049.sortString(strs));
    }
}

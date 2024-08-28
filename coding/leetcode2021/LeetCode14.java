package leetcode2021;

/**
 * @author yuyunlong
 * @date 2021/1/9 10:44 上午
 * @description 最长公共前缀
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }



    public static void main(String[] args) {
        String[] strs = new String[]{"reflower","flow","flight"};
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(strs));
    }
}

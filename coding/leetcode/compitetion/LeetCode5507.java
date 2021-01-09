package leetcode.compitetion;

/**
 * @author yuyunlong
 * @date 2020/9/6 10:49 上午
 * @description 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，
 * 使最终的字符串不包含任何 连续重复 的字符。
 */
public class LeetCode5507 {
    public String modifyString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '?') {
                array[i] = replaceConfuse(array, i);
            }
        }
        return new String(array);
    }

    private char replaceConfuse(char[] array, int i) {
        char pre = '0', next = '0';
        if (i - 1 >= 0) {
            pre = array[i - 1];
        }
        if (i + 1 < array.length) {
            next = array[i + 1];
        }
        for(char test = 'a'; test <= 'z'; test++) {
            if (test != pre && test != next) {
                return test;
            }
        }
        return '0';
    }
}

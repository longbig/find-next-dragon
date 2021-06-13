package leetcode.medium;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2021/6/13 10:22 上午
 * @description 翻转字符串里的单词，需要去掉多余的空格
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        //使用栈的特性
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuffer word = new StringBuffer();
        LinkedList<String> stack = new LinkedList<>();
        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && c == ' ') {
                stack.push(word.toString());
                word.setLength(0);
            }
            if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        stack.push(word.toString());
        return String.join(" ", stack);
    }

    public static void main(String[] args) {
        String value = "  123 weiou wuoit   wtui   ";

        LeetCode151 test = new LeetCode151();
        System.out.println(test.reverseWords(value));
    }
}

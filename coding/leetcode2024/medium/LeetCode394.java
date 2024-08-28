package leetcode2024.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2024/8/28 8:56
 * @description 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class LeetCode394 {

    public String decodeString(String s) {
        //用栈存储字符串
        char[] array = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            char temp = array[i];
            if (temp != ']') {
                stack.push(temp);
                continue;
            }

            StringBuffer subCharString = new StringBuffer();
            while (!stack.isEmpty() && stack.peek() != '[') {
                subCharString.append(stack.pop());
            }
            StringBuffer subNumString = new StringBuffer();
            if (!stack.isEmpty()) {
                stack.pop();
                while (!stack.isEmpty() && (stack.peek() >= '0' && stack.peek() <=  '9')) {
                    subNumString.append(stack.pop());
                }
            }
            //组合，重新入栈
            int num = Integer.valueOf(subNumString.reverse().toString());
            String subString  = subCharString.reverse().toString();
            char[] subTemp = subString.toCharArray();
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < subTemp.length; k++) {
                    stack.push(subTemp[k]);
                }
            }
        }
        //栈中元素是最终字符串
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}

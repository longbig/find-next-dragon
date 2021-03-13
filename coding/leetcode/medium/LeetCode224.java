package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yuyunlong
 * @date 2021/2/10 5:52 下午
 * @description 基本计算器
 */
public class LeetCode224 {

    private Stack<Integer> numStack = new Stack<>();
    private Stack<Character> charStack = new Stack<>();

    private Map<Character, Integer> charMap = new HashMap<Character, Integer>(){{
        put(')', 0);
        put('(', 1);
        put('+', 2);
        put('-', 2);
    }};

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp == ' ') {
                continue;
            }

            if (isNum(temp)) {
                //多位数处理
                if (i > 0 && isNum(chars[i - 1])) {
                    Integer peekNum = numStack.pop();
                    peekNum = peekNum * 10 + temp;
                    numStack.push(peekNum);
                } else {
                    numStack.push((int)temp - 48);
                }
            } else {
                if (!charStack.isEmpty()) {
                    Character peekChar = charStack.peek();
                    if (charMap.get(peekChar) >= charMap.get(temp) && temp != '('
                            && temp != ')') {
                        //计算
                        int b = numStack.pop();
                        int a = numStack.pop();
                        sum = compu(a, b, temp);
                        numStack.push(sum);
                    } else if (temp == ')') {
                        charStack.pop();
                    }
                } else {
                    charStack.push(temp);
                }
            }
        }

        if (!numStack.isEmpty() && !charStack.isEmpty()) {
            int b = numStack.pop();
            int a = numStack.pop();
            sum = compu(a, b, charStack.pop());
        }

        return sum;
    }

    private boolean isNum(char data) {
        if (data >= '0' && data <= '9') {
            return true;
        }
        return false;
    }

    private int compu(int a, int b, char temp) {
        switch (temp){
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s = "1+2-3 ";
        LeetCode224 test = new LeetCode224();
//        System.out.println(test.calculate(s));
//        System.out.println((int)'0');
        System.out.println("test".substring(1,2));
    }
}

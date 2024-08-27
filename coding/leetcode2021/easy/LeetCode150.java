package leetcode2021.easy;

import java.util.Stack;

/**
 * @author yuyunlong
 * @date 2021/3/20 7:06 下午
 * @description
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token)) && !("-".equals(token)) && !("*".equals(token)) && !("/".equals(token));
    }

    public static void main(String[] args) {
        LeetCode150 test = new LeetCode150();
        String[] array = {"4","13","5","/","+"};
        System.out.println(test.evalRPN(array));
    }
}

package meituan;

import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2021/6/1 7:45 下午
 * @description 双栈排序，美团面试题 https://leetcode-cn.com/circle/discuss/rWQX9q/
 */
public class DoubleStackSort {

    /**
     * 两个栈实现排序，允许使用一个额外栈辅助
     *
     * @param stack
     * @return
     */
    public LinkedList<Integer> sort(LinkedList<Integer> stack) {
        //思路，辅助栈一定要是排序好的，所以遇到更小的元素时，辅助栈一直出栈元素，直到合适的位置
        LinkedList<Integer> temp = new LinkedList<>();
        while (!stack.isEmpty()) {
            Integer peak = stack.pop();
            while (!temp.isEmpty() && temp.peek() > peak) {
                Integer nowNode = temp.pop();
                stack.push(nowNode);
            }
            temp.push(peak);
        }
        return temp;
    }

    public static void main(String[] args) {
        DoubleStackSort test = new DoubleStackSort();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        LinkedList<Integer> res = test.sort(stack);
        while (!res.isEmpty()) {
            Integer value = res.pop();
            System.out.println(value);
        }
    }
}

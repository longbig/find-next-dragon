package leetcode.easy;

import algorithm.MinStack;

/**
 * @author yuyunlong
 * @date 2021/6/5 10:30 上午
 * @description
 */
public class LeetCode155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

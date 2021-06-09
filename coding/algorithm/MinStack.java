package algorithm;

import java.util.LinkedList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yuyunlong
 * @date 2021/6/5 10:30 上午
 * @description https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> secStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        secStack = new LinkedList<>();
        secStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        secStack.push(Math.min(val, secStack.peek()));

    }

    public void pop() {
        stack.pop();
        secStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return secStack.peek();
    }
}

package leetcode2024.medium;

import java.util.*;

/**
 * @author Administrator
 * @date 2024/8/26 11:24
 * @description 实现一个最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 */
public class LeetCode155 {

    Deque<Integer> stack;
    Queue<Integer> priorityQueue;


    public LeetCode155() {
        stack = new LinkedList<>();
        priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.add(val);

    }

    public void pop() {
        Integer value = stack.pop();
        priorityQueue.remove(value);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}

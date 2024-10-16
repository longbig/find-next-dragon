package leetcode2024.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuyunlong
 * @date 2024/10/13 12:17
 * @description 295. 数据流的中位数
 */
public class LeetCode295 {

    PriorityQueue<Integer> leftQueue;

    PriorityQueue<Integer> rightQueue;

    //解题思路：用两个堆来实现
    public LeetCode295() {
        leftQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                }
                return -1;
            }
        });
        rightQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public void addNum(int num) {
        int leftSize = leftQueue.size(), rightSize = rightQueue.size();
        if (leftQueue.isEmpty() || num < leftQueue.peek()) {
            leftQueue.offer(num);
            if (leftQueue.size() - rightSize > 1) {
                rightQueue.offer(leftQueue.poll());
            }
        } else {
            rightQueue.offer(num);
            if (rightQueue.size() - leftSize > 1) {
                leftQueue.offer(rightQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (leftQueue.size() == rightQueue.size()) {
            double result = (leftQueue.peek() + rightQueue.peek()) / 2.0;
            return result;
        }
        if (leftQueue.size() > rightQueue.size()) {
            return leftQueue.peek();
        }
        return rightQueue.peek();
    }
}

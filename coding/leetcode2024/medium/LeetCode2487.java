package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yuyunlong
 * @date 2024/10/6 21:46
 * @description 2487. 从链表中移除节点
 */
public class LeetCode2487 {

    //单调栈解法
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new LinkedList<>();
        while(head != null) {
            while (!stack.isEmpty() && head.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }
        //重新构建链表
        ListNode tail = null;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            curr.next = tail;
            tail = curr;
        }
        return tail;
    }
}

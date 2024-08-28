package leetcode2024.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/13 00:37
 * @description 环形链表，判断链表是否有环
 */
public class LeetCode141 {

    //快慢指针解法
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }

    //面向测试编程，题目规定了链表节点数在10000以内
    public boolean hasCycleFor1W(ListNode head) {
        if (head == null) {
            return false;
        }
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
            if (count > 10000) {
                return true;
            }
        }
        return false;
    }
}

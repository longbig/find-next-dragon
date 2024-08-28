package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/18 19:39
 * @description 24. 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class LeetCode024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode();
        ListNode tt = temp;
        temp.next = head;
        ListNode fast = temp, slow = temp;
        fast = fast.next.next;
        slow = slow.next;
        while (fast != null && slow != null) {
            slow.next = fast.next;
            fast.next = slow;
            temp.next = fast;

            if (slow.next == null || slow.next.next == null) {
                break;
            }
            temp = slow;
            fast = slow.next.next;
            slow = slow.next;

        }
        return tt.next;
    }

    /**
     * 官方递归解法
     * @param head
     * @return
     */
    public ListNode swapPairsForDigui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}

package leetcode2024.hard;

import leetcode2021.compitetion.ListNode;

/**
 * @author Administrator
 * @date 2024/9/19 9:31
 * @description 25. K 个一组翻转链表
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LeetCode025 {

    //递归思路解决，每次反转k个节点，反转之后的tail的next就是新链表的头节点
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //判断不足k个节点时，不翻转了
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        ListNode nextHead = reverseKGroup(tail, k);
        head.next = nextHead;
        return newHead;

    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

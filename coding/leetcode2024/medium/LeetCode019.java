package leetcode2024.medium;

import leetcode.compitetion.ListNode;

/**
 * @author Administrator
 * @date 2024/8/16 19:06
 * @description 删除链表的倒数第N个节点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode019 {

    /**
     * 双指针解法，相隔n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp, fast = temp;
        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return temp.next;


    }
}

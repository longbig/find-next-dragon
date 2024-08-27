package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author Administrator
 * @date 2024/8/13 8:55
 * @description 环形链表II
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class LeetCode142 {

    /**
     * 快慢指针解法
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        int initStep = 0;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            initStep++;
            if (fast.equals(slow)) {
                //环里相交
                break;
            }
        }

        if (fast.next == null || fast.next.next != null) {
            return null;
        }
        ListNode fast1 = head, slow1 = head;
        while (initStep > 0) {
            fast1 = fast1.next;
            initStep--;
        }
        while (!fast1.equals(slow1)) {
            fast1 = fast1.next;
            slow1 = slow1.next;
        }
        return fast1;

    }
}

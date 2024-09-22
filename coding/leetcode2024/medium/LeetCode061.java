package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/9/21 16:26
 * @description 61. 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LeetCode061 {

    //解法：就是将链表后面k个节点移动到前半部分就行，用快慢指针解决
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int len = 1;
        while (fast.next != null) {
            fast = fast.next;
            len++;
        }
        k = k % len;
        fast = head;
        if (k == 0) {
            return head;
        }
        while (k-- > 0) {
           fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;

    }
}

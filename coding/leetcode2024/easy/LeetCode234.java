package leetcode2024.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/13 00:16
 * @description 回文链表
 */
public class LeetCode234 {

    /**
     * 快慢指针，走到中间，反转链表，顺序比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean result = true;
        ListNode firstEnd = findFirstHalfEnd(head);
        ListNode secondStart = reverseList(firstEnd.next);
        ListNode ff = head;
        while (result && secondStart != null) {
            if (ff.val != secondStart.val) {
                result = false;
            }
            ff = ff.next;
            secondStart = secondStart.next;
        }
        return result;

    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //快慢指针找中间结点
    private ListNode findFirstHalfEnd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

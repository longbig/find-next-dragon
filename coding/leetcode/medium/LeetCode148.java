package leetcode.medium;

import leetcode.compitetion.ListNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuyunlong
 * @date 2021/5/25 9:14 上午
 * @description 可理解为链表的归并排序
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        //slow为中间点
        ListNode mid = slow;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        ListNode mergedNode = mergeList(l1, l2);
        return mergedNode;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode temp = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return fakeHead.next;
    }


}

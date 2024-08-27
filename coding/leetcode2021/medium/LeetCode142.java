package leetcode2021.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/6/11 10:45 上午
 * @description
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode third = head;
                while (third != slow) {
                    third = third.next;
                    slow = slow.next;
                }
                return third;
            }

        }
        return null;
    }
}

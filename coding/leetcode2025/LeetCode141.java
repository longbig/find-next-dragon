package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/27 20:32
 * @description
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        //快慢指针解法
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

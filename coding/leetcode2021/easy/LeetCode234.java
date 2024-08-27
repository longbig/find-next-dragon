package leetcode2021.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/5/30 10:01 上午
 * @description 判断回文链表
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //找到中间结点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //奇数slow在中间，偶数slow在中间后移一个结点处
        ListNode pre = null, curr = null;
        //反转后半部分
        while (slow != null) {
            curr = slow.next;
            slow.next = pre;
            pre = slow;
            slow = curr;
        }
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;

    }
}

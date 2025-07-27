package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/27 20:48
 * @description
 */
public class LeetCode234 {

    //先找到中间节点，反转右边链表，再比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode right = reverseList(mid);
        while (right != null && head != mid) {
            if (right.val != head.val) {
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;

    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //迭代方法
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

}

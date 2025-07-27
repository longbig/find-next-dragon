package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/27 17:59
 * @description
 */
public class LeetCode083 {

    public ListNode deleteDuplicates(ListNode head) {
        //双指针法，遍历到不同数值的节点，把中间重复的删除
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

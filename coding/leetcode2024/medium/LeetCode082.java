package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/9/22 14:45
 * @description 82. 删除排序链表中的重复元素 II
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LeetCode082 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = new ListNode(-101);
        tempHead.next = head;
        ListNode curr = tempHead;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return tempHead.next;
    }
}

package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/10/5 10:53
 * @description 86. 分隔链表
 */
public class LeetCode086 {

    //构造两个子链解决
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(0);
        ListNode tt = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode tempNode = largeHead;
        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                largeHead.next = head;
                largeHead = largeHead.next;
            }
            head = head.next;
        }
        largeHead.next = null;
        smallHead.next = tempNode.next;
        return tt.next;
    }
}

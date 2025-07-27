package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/27 20:36
 * @description 单链表的反转
 */
public class LeetCode206 {

    //递归解法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //断开head的next连接
        head.next.next = head;
        head.next = null;
        return newHead;


    }
}

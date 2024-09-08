package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

/**
 * @author Administrator
 * @date 2024/9/8 16:30
 * @description 92. 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 简述：只反转链表中的一段
 */
public class LeetCode092 {

    /**
     * 要求：只能用一次扫描,官方解法2，用一个指针遍历待反转部分，然后把curr当前节点移动到待反转链表的头部
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pre = temp;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //pre 在left的前一个节点
        ListNode curr = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return temp.next;

    }

    /**
     * 要求：只能用一次扫描,我的方法是leetcode官方解法1，反转中间的部分，然后和首尾接起来
     */
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode tempHead = new ListNode(0);
//        tempHead.next = head;
//        ListNode pre = tempHead, curr = head;
//        int count = 0;
//        while (++count < left) {
//            pre = pre.next;
//            curr = curr.next;
//        }
//        //curr指向left，pre指向前节点
//        ListNode ppre = pre, pptail = curr;
//        pre = null;
//        while (count++ <= right) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        //curr指向right的下一个节点，pre是新头节点
//        ppre.next = pre;
//        pptail.next = curr;
//        return tempHead.next;
//
//    }
}

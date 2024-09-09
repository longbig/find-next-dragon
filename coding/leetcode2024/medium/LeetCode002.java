package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @date 2024/8/14 8:56
 * @description 两数相加
 *
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LeetCode002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0) {
            return l2;
        }
        if (l2.next == null && l2.val == 0) {
            return l1;
        }
        ListNode l3 = new ListNode();
        ListNode head = l3;
        boolean extraFlag = false;
        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                l1 = new ListNode(0);
            }
            if (l2 == null && l1 != null) {
                l2 = new ListNode(0);
            }

            int sum = l1.val + l2.val;
            if (extraFlag) {
                sum += 1;
            }

            if (sum >= 10) {
                extraFlag = true;
            } else {
                extraFlag = false;
            }
            ListNode newNode = new ListNode(sum % 10);
            l3.next = newNode;
            l3 = l3.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        //处理结尾进位的情况
        if (extraFlag) {
            ListNode lastNode = new ListNode(1);
            l3.next = lastNode;
        }
        return head.next;
    }
}

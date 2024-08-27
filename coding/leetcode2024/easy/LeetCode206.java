package leetcode2024.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/12 23:19
 * @description 反转链表
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        //用一个中间结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hh = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = hh;
            hh = temp;

        }
        return hh;
    }


    /**
     * 按递归的方法
     * @param head
     * @return
     */
    public ListNode reverseListForDigui(ListNode head) {
        //用一个中间结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListForDigui(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        h1.next = h2;
        h2.next = h3;
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode hh = leetCode206.reverseList(h1);

        System.out.println(hh.val + " " + hh.next.val + " " + hh.next.next.val);

    }
}
